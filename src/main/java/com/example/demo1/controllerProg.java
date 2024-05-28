package com.example.demo1;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;


public class controllerProg implements Initializable{
    public ComboBox typeSeance;
    public ComboBox comb1;
    private int duree;
    @FXML
    private ComboBox comb;
    @FXML
    private AnchorPane consultationContainer;
    @FXML
    private AnchorPane seanceContainer;
    @FXML
    private TextField champsNom;
    @FXML
    private TextField champsPrenom;
    @FXML
    private TextField champsAge;
    @FXML
    private TextField champsDossier;
    @FXML
    private TextField champsThematique;
    @FXML
    private Button button;
    @FXML
    private AnchorPane atelierContainer;
    @FXML
    private ListView listeDossiers;
    private BooleanProperty consultationActive = new SimpleBooleanProperty(false);
    private BooleanProperty suiviActive = new SimpleBooleanProperty(false);
    private BooleanProperty atelierActive = new SimpleBooleanProperty(false);
    private LocalDate date;
    private LocalTime time;
    private CalendarController calendarController;
    public void setDate(LocalDate selectedDate) {
        date = selectedDate;
    }
    public void setTime(LocalTime selectedDate) {
        time = selectedDate;
    }

    public void setCalendarController(CalendarController calendarController) {
        this.calendarController = calendarController;
    }
    public void Select (ActionEvent event) {
        String s =comb.getSelectionModel().getSelectedItem().toString();
        switch (s) {
            case "Consultation":
                consultationActive.set(true);
                suiviActive.set(false);
                atelierActive.set(false);
                break;
            case "Seance de suivi":
                consultationActive.set(false);
                suiviActive.set(true);
                atelierActive.set(false);
                break;
            case "Atelier":
                consultationActive.set(false);
                suiviActive.set(false);
                atelierActive.set(true);
                break;
            default:
                consultationActive.set(false);
                suiviActive.set(false);
                atelierActive.set(false);
                break;
        }
    }
    public void initialize (URL url, ResourceBundle rb ) {
        ObservableList list = FXCollections.observableArrayList("Consultation","Seance de suivi","Atelier");
        comb.setItems(list);
        ObservableList list2 = FXCollections.observableArrayList("En présentiel","En ligne");
        typeSeance.setItems((list2));
        consultationContainer.disableProperty().bind(consultationActive.not());
        seanceContainer.disableProperty().bind(suiviActive.not());
        atelierContainer.disableProperty().bind(atelierActive.not());

    }
    public void selectDossier() {
        String s =comb1.getSelectionModel().getSelectedItem().toString();
        listeDossiers.getItems().add(s);
    }
    public void creationRdv(ActionEvent event) throws IOException {
        if(consultationActive.get()){
            String patientNom= champsNom.getText();
            String patientPrenom =champsPrenom.getText();
            int patientAge = Integer.parseInt(champsAge.getText());
            if(patientAge<=18) {
                duree = 150;
            }
            else{
                duree = 90;
            }
            calendarController.setDuree(duree);
            Consultation cons = new Consultation(patientNom,patientPrenom,patientAge);
            cons.programmer(date,time,duree);
            calendarController.ajouterRdv(cons);
        }
        else if(suiviActive.get()) {
            int numDossier = Integer.parseInt(champsDossier.getText());
            String typesnc = typeSeance.getSelectionModel().getSelectedItem().toString();
            TypeSeance type;
            if(typesnc=="En présentiel") {
                type = TypeSeance.PRESENTIEL;
            }
            else{
                type = TypeSeance.ENLIGNE;
            }
            duree = 60;
            calendarController.setDuree(duree);
            SeanceSuivi seance = new SeanceSuivi(numDossier,type);
            seance.programmer(date, time, duree);
            calendarController.ajouterRdv(seance);
        }
        else if(atelierActive.get()) {
            String theme = champsThematique.getText();

        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

}