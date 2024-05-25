package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarController implements Initializable {

    ZonedDateTime dateFocus;
    ZonedDateTime today;
    private static List<RendezVous> calendarActivities = new ArrayList<>();
    @FXML
    private Text year;
    @FXML
    private Button button;
    @FXML
    private Text month;

    @FXML
    private FlowPane calendar;
    private ZonedDateTime selectedDate;
    private LocalTime selectedTime;
    @FXML
    private ListView<String> timeSlotsListView;
    private static Map<LocalDate, List<LocalTime>> availableTimeSlotsMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();
        drawCalendar();
        generateAvailableTimeSlots();
    }

    private List<LocalTime> generateTimeSlots() {
        List<LocalTime> slots = new ArrayList<>();
        for (int i = 8; i < 17; i++) { // 8 AM to 5 PM
            slots.add(LocalTime.of(i, 0));
            slots.add(LocalTime.of(i, 30));
        }
        return slots;
    }
    private void generateAvailableTimeSlots() {
        for (int i = 1; i <= dateFocus.getMonth().length(dateFocus.toLocalDate().isLeapYear()); i++) {
            LocalDate currentDate = dateFocus.withDayOfMonth(i).toLocalDate();
            availableTimeSlotsMap.put(currentDate, generateTimeSlots());
        }
    }

    private void updateAvailableSlots(LocalDate date, LocalTime time) {
        if (availableTimeSlotsMap.containsKey(date)) {
            List<LocalTime> slots = availableTimeSlotsMap.get(date);
            availableTimeSlotsMap.remove(date);
            slots.remove(time);

            availableTimeSlotsMap.put(date, slots);
        }
    }

    public List<RendezVous> getCalendarActivities() {
        return calendarActivities;
    }

    public void refreshCalendar() {
        calendar.getChildren().clear();
        drawCalendar();
    }

    private Map<LocalDate, List<RendezVous>> getCalendarActivitiesMonth(ZonedDateTime dateFocus) {
        Map<LocalDate, List<RendezVous>> calendarActivityMap = new HashMap<>();
        for (RendezVous activity : calendarActivities) {
            LocalDate activityDate = activity.getDate();
            calendarActivityMap.computeIfAbsent(activityDate, k -> new ArrayList<>()).add(activity);
        }
        return calendarActivityMap;
    }

    @FXML
    void backOneMonth(ActionEvent event) {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void forwardOneMonth(ActionEvent event) {
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }
    private void drawCalendar() {
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        Map<LocalDate, List<RendezVous>> calendarActivityMap = getCalendarActivitiesMonth(dateFocus);

        int monthMaxDate = dateFocus.getMonth().maxLength();
        if (dateFocus.getYear() % 4 != 0 && monthMaxDate == 29) {
            monthMaxDate = 28;
        }
        int dateOffset = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1, 0, 0, 0, 0, dateFocus.getZone()).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();

                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth = (calendarWidth / 7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight / 6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j + 1) + (7 * i);
                if (calculatedDate > dateOffset) {
                    int currentDate = calculatedDate - dateOffset;
                    if (currentDate <= monthMaxDate) {
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = -(rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);

                        LocalDate dateForActivities = dateFocus.withDayOfMonth(currentDate).toLocalDate();
                        List<RendezVous> calendarActivities = calendarActivityMap.get(dateForActivities);
                        if (calendarActivities != null) {
                            createCalendarActivity(calendarActivities, rectangleHeight, rectangleWidth, stackPane);
                        }
                        int finalCurrentDate = currentDate;
                        rectangle.setOnMouseClicked(event -> {
                            selectedDate = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), finalCurrentDate, 0, 0, 0, 0, dateFocus.getZone());
                            List<LocalTime> availableSlots = availableTimeSlotsMap.get(selectedDate.toLocalDate());
                            System.out.println(availableSlots);
                            showAvailableTimeSlots(availableSlots);
                        });

                    }
                    if (today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate) {
                        rectangle.setStroke(Color.BLUE);
                    }
                }
                if (!calendar.getChildren().contains(stackPane)) {
                    calendar.getChildren().add(stackPane);
                }

            }
        }
    }

    private void showAvailableTimeSlots(List<LocalTime> availableTimeSlots) {
        if (availableTimeSlots == null || availableTimeSlots.isEmpty()) {
            return;
        }

        timeSlotsListView.getItems().clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        for(LocalTime timeSlot : availableTimeSlots) {
            timeSlotsListView.getItems().add(timeSlot.format(formatter));
        }
        timeSlotsListView.setVisible(true);
        timeSlotsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedTime = LocalTime.parse(newValue, formatter);

                selectedDate = selectedDate.withHour(selectedTime.getHour()).withMinute(selectedTime.getMinute());

                button.setVisible(true);
            }
        });
    }




    public void ajouterRdv(RendezVous rdv) {
        calendarActivities.add(rdv);
        System.out.println("Date et heure : "+rdv.getDate()+selectedTime);
        updateAvailableSlots(rdv.getDate(),selectedTime);
        System.out.println(availableTimeSlotsMap.get(rdv.getDate()));
        refreshCalendar();
    }

    private void createAppointment(ZonedDateTime selectedDate) {
        if (selectedDate == null) {
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/rdvScene.fxml"));
            Parent root = loader.load();
            controllerProg controller = loader.getController();
            controller.setDate(selectedDate.toLocalDate());
            controller.setTime(selectedTime);
            controller.setCalendarController(this);
            Stage stage = new Stage();
            stage.setTitle("Créer un rendez-vous");
            stage.setScene(new Scene(root));
            stage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openAppointmentForm(ActionEvent event) {
        createAppointment(selectedDate);
    }

    private void createCalendarActivity(List<RendezVous> calendarActivities, double rectangleHeight, double rectangleWidth, StackPane stackPane) {
        if (calendarActivities == null || stackPane == null) {
            return;
        }
        VBox calendarActivityBox = new VBox();
        for (int k = 0; k < calendarActivities.size(); k++) {
            if (k >= 2) {
                Text moreActivities = new Text("...");
                calendarActivityBox.getChildren().add(moreActivities);
                moreActivities.setOnMouseClicked(mouseEvent -> {
                    System.out.println(calendarActivities);
                });
                break;
            }
            RendezVous rdv = calendarActivities.get(k);
            Text text = new Text(rdv.getTime().toString());
            calendarActivityBox.getChildren().add(text);
            text.setOnMouseClicked(mouseEvent -> {
                System.out.println(text.getText());
            });
        }
        calendarActivityBox.setTranslateY((rectangleHeight / 2) * 0.20);
        calendarActivityBox.setMaxWidth(rectangleWidth * 0.8);
        calendarActivityBox.setMaxHeight(rectangleHeight * 0.65);
        calendarActivityBox.setStyle("-fx-background-color:#4b0082");
        stackPane.getChildren().add(calendarActivityBox);
    }
}
