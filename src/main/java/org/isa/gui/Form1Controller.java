package org.isa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Form1Controller {
    public Button btnBack;
    @FXML
    private TextField Nom;
    @FXML
    private Button button1;
    @FXML
    private Label Label1;

    public void button1_click(ActionEvent actionEvent) {
        Label1.setText("Bonjour " + Nom.getText());
    }

    public void goBackToMenu(ActionEvent actionEvent)  throws IOException {

        // 1. On crée le Parent qui contient le FXMLLoader "chargeur" de fxml avec l'adresse du fichier:
        Parent menuParent = FXMLLoader.load(getClass().getResource("/org/isa/gui/menu.fxml"));
        // 2. On l'injecte dans la scene:
        Scene menuScene = new Scene(menuParent);
        // 3. On récupère la stage
        //casting our event as a node, to then get the scene and the window, and then formally cast the window as a stage
        Stage window = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        // assigne la scene au stage:
        window.setScene(menuScene);
        window.setTitle("SceneBuilder is my new best friend !!!");
        // 4. On affiche le stage:
        window.show();

    }
}
