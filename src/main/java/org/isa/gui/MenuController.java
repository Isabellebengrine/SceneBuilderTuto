package org.isa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    public Label titre;
    public Button btnForm1;
    public Button btnAdditionneur;
    public Button btnCheckboxes;
    public Button btnMelangeur;
    public Button btnTableview;

    public void afficheForm1(ActionEvent actionEvent) throws IOException {
        // 1. On crée le Parent qui contient le FXMLLoader "chargeur" de fxml avec l'adresse du fichier:
        Parent form1Parent = FXMLLoader.load(getClass().getResource("/org/isa/gui/form1.fxml"));
        // 2. On l'injecte dans la scene:
        Scene checkboxesScene = new Scene(form1Parent);
        // 3. On récupère la stage
        //casting our event as a node, to then get the scene and the window, and then formally cast the window as a stage
        Stage window = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        // assigne la scene au stage:
        window.setScene(checkboxesScene);
        window.setTitle("Say hello to SceneBuilder !!!");
        // 4. On affiche le stage:
        window.show();
    }

    public void afficheAdditionneur(ActionEvent actionEvent) throws IOException {
        // 1. On crée le Parent qui contient le FXMLLoader "chargeur" de fxml avec l'adresse du fichier:
        Parent additionneurParent = FXMLLoader.load(getClass().getResource("/org/isa/gui/additionneur.fxml"));
        // 2. On l'injecte dans la scene:
        Scene checkboxesScene = new Scene(additionneurParent);
        // 3. On récupère la stage
        //casting our event as a node, to then get the scene and the window, and then formally cast the window as a stage
        Stage window = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        // assigne la scene au stage:
        window.setScene(checkboxesScene);
        window.setTitle("Buttons everywhere !!!");
        // 4. On affiche le stage:
        window.show();
    }

    public void afficheCheckboxes(ActionEvent actionEvent) throws IOException {
        // 1. On crée le Parent qui contient le FXMLLoader "chargeur" de fxml avec l'adresse du fichier:
        Parent checkboxParent = FXMLLoader.load(getClass().getResource("/org/isa/gui/checkboxes.fxml"));
        // 2. On l'injecte dans la scene:
        Scene checkboxesScene = new Scene(checkboxParent);
        // 3. On récupère la stage
        //casting our event as a node, to then get the scene and the window, and then formally cast the window as a stage
        Stage window = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        // assigne la scene au stage:
        window.setScene(checkboxesScene);
        window.setTitle("Checkboxes everywhere !!!");
        // 4. On affiche le stage:
        window.show();

    }

    public void afficheMelangeur(ActionEvent actionEvent) throws IOException {
        // 1. On crée le Parent qui contient le FXMLLoader "chargeur" de fxml avec l'adresse du fichier:
        Parent melangeurParent = FXMLLoader.load(getClass().getResource("/org/isa/gui/melangeur.fxml"));
        // 2. On l'injecte dans la scene:
        Scene melangeurScene = new Scene(melangeurParent);
        // 3. On récupère la stage
        //casting our event as a node, to then get the scene and the window, and then formally cast the window as a stage
        Stage window = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        // assigne la scene au stage:
        window.setScene(melangeurScene);
        window.setTitle("Mixing colors !!!");
        // 4. On affiche le stage:
        window.show();
    }

    public void afficheTableview(ActionEvent actionEvent) throws IOException {
        // 1. On crée le Parent qui contient le FXMLLoader "chargeur" de fxml avec l'adresse du fichier:
        Parent tableviewParent = FXMLLoader.load(getClass().getResource("/org/isa/gui/tableview.fxml"));
        // 2. On l'injecte dans la scene:
        Scene tableviewScene = new Scene(tableviewParent);
        // 3. On récupère la stage
        //casting our event as a node, to then get the scene and the window, and then formally cast the window as a stage
        Stage window = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        // assigne la scene au stage:
        window.setScene(tableviewScene);
        window.setTitle("Example of Tableview");
        // 4. On affiche le stage:
        window.show();
    }
}
