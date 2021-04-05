package org.isa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MelangeurController {
    public Label resultat;
    public Label labelRouge;
    public Slider sliderRouge;
    public Slider sliderVert;
    public Slider sliderBleu;
    public Label labelVert;
    public Label labelBleu;
    public Button btnBack;

    public void melanger(MouseEvent mouseEvent){
        //fixer les valeurs min et max de chaque slider :
        sliderRouge.setMin(0);
        sliderRouge.setMax(255);
        sliderVert.setMin(0);
        sliderVert.setMax(255);
        sliderBleu.setMin(0);
        sliderBleu.setMax(255);

        // récupère la valeur des sliders et la typecast en int
        int valeurRouge = (int)(sliderRouge.getValue());
        int valeurVert = (int)(sliderVert.getValue());
        int valeurBleu = (int)(sliderBleu.getValue());

        //applique les couleurs au label resultat :
        resultat.setStyle("-fx-background-color: rgb(" + valeurRouge + "," + valeurVert + "," + valeurBleu + ");");
    }

    public void goBackToMenu(ActionEvent actionEvent) throws IOException {

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
