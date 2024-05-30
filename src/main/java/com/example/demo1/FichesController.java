package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class FichesController {

    @FXML
    private Label eight;

    @FXML
    private Label five;

    @FXML
    private Label four;

    @FXML
    private Label nine;

    @FXML
    private Label one;

    @FXML
    private Label seven;

    @FXML
    private Label six;

    @FXML
    private Label three;

    @FXML
    private Label two;

    private Label[] labels;
    private EpreuveClinique epreuveClinique;
    private BO bo;
    private Patient patient;

    @FXML
    public void initialize() {
        labels = new Label[]{one, two, three, four, five, six, seven, eight, nine};
    }

    @FXML
    void add1(MouseEvent event) {
        handleAddClick(0);
    }

    @FXML
    void add2(MouseEvent event) {
        handleAddClick(1);
    }

    @FXML
    void add3(MouseEvent event) {
        handleAddClick(2);
    }

    @FXML
    void add4(MouseEvent event) {
        handleAddClick(3);
    }

    @FXML
    void add5(MouseEvent event) {
        handleAddClick(4);
    }

    @FXML
    void add6(MouseEvent event) {
        handleAddClick(5);
    }

    @FXML
    void add7(MouseEvent event) {
        handleAddClick(6);
    }

    @FXML
    void add8(MouseEvent event) {
        handleAddClick(7);
    }

    @FXML
    void add9(MouseEvent event) {
        handleAddClick(8);
    }

    private void handleAddClick(int index) {
        Label label = labels[index];
        if (label.getText().startsWith("F ")) {
            navigateToObjectif(index);
        } else if (label.getText().isEmpty() || "+".equals(label.getText())) {
            navigateToAddObjectif(index);
        } else {
            Fiche fiche = loadFiche(index);
            if (fiche != null) {
                navigateToEditObjectif(fiche, index);
            }
        }
    }

    private void navigateToObjectif(int index) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Objectif.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Makes the window modal
            stage.setScene(new Scene(loader.load()));

            ObjectifController controller = loader.getController();
            controller.setIndex(index); // Pass the index to the controller
            Fiche fiche = loadFiche(index);
            if (fiche != null) {
                controller.setFiche(fiche);
            }

            stage.showAndWait(); // Waits for the window to close
            updateLabels();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void navigateToAddObjectif(int index) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterObjectif.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Makes the window modal
            stage.setScene(new Scene(loader.load()));

            AjouterObjectifController controller = loader.getController();
            controller.setIndex(index); // Pass the index to the controller

            stage.showAndWait(); // Waits for the window to close

            if (controller.isCompleted()) {
                // Assuming you want to change the label text when the process is completed
                labels[index].setText("F " + (index + 1));
                saveFiche(controller.getFiche(), index); // Save the fiche (with objectives and score)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void navigateToEditObjectif(Fiche fiche, int index) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterObjectif.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Makes the window modal
            stage.setScene(new Scene(loader.load()));

            AjouterObjectifController controller = loader.getController();
            controller.setFiche(fiche); // Set the fiche data in the controller
            controller.setIndex(index); // Pass the index to the controller

            stage.showAndWait(); // Waits for the window to close

            if (controller.isCompleted()) {
                saveFiche(controller.getFiche(), index); // Save the fiche (with objectives and score)
            }
            updateLabels();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Fiche loadFiche(int index) {
        File file = new File("fiche" + index + ".ser");
        if (!file.exists()) {
            return null; // File does not exist, return null
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Fiche) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveFiche(Fiche fiche, int index) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fiche" + index + ".ser"))) {
            oos.writeObject(fiche);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateLabels() {
        for (int i = 0; i < labels.length; i++) {
            if (new File("fiche" + i + ".ser").exists()) {
                labels[i].setText("F " + (i + 1));
            } else {
                labels[i].setText("+");
            }
        }
    }

    public void initData(EpreuveClinique epreuveClinique, BO bo, Patient patient) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patient = patient;
        // Further initialization if needed
    }
}
