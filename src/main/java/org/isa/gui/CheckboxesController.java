package org.isa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckboxesController implements Initializable {
    public Label resultat;
    public Label labeltexte;
    public Label labelcasse;
    public Label labelchoix;
    public Label labelfond;
    public CheckBox boxtxtblanc;
    public CheckBox boxtxtnoir;
    public CheckBox boxtxtrouge;
    public CheckBox boxtexte;
    public CheckBox boxcasse;
    public CheckBox boxcassemin;
    public CheckBox boxcassemaj;
    public CheckBox boxfondvert;
    public CheckBox boxfondbleu;
    public CheckBox boxfondrouge;
    public CheckBox boxfond;
    public TextArea saisie;
    public Button btnBack;

    public void afficheOptionsChoix(InputEvent inputEvent) {
        labelchoix.setDisable(false);
        boxfond.setDisable(false);
        boxcasse.setDisable(false);
        boxtexte.setDisable(false);

        //afficher texte saisi dans label :
        resultat.setText(saisie.getText());
    }

    public void afficheOptionsFond(ActionEvent actionEvent) {
        boxfond.setSelected(true);
        labelfond.setDisable(false);
        boxfondrouge.setDisable(false);
        boxfondbleu.setDisable(false);
        boxfondvert.setDisable(false);
    }

    public void applyRedBackgdColor(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre couleur) :
        boxfondrouge.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de background :
        boxfondvert.setSelected(false);
        boxfondbleu.setSelected(false);

        //et 2. j'applique le style choisi :
        resultat.setStyle(resultat.getStyle() + "-fx-background-color: red;");

    }

    public void applyBlueBackgdColor(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre couleur) :
        boxfondbleu.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de background :
        boxfondvert.setSelected(false);
        boxfondrouge.setSelected(false);

        //et 2. j'applique le style choisi :
        resultat.setStyle(resultat.getStyle() + "-fx-background-color: blue;");
    }

    public void applyGreenBackgdColor(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre couleur) :
        boxfondvert.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de background :
        boxfondrouge.setSelected(false);
        boxfondbleu.setSelected(false);

        //et 2. j'applique le style choisi :
        resultat.setStyle(resultat.getStyle() + "-fx-background-color: green;");
    }

    public void applyUpperCase(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre box) :
        boxcassemaj.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de même catégorie:
        boxcassemin.setSelected(false);
        //et 2. j'applique le style choisi :
        resultat.setText(resultat.getText().toUpperCase());
    }

    public void applyLowerCase(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre couleur) :
        boxcassemin.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de même catégorie :
        boxcassemaj.setSelected(false);
        //et 2. j'applique le style choisi :
        resultat.setText(resultat.getText().toLowerCase());
    }

    public void afficheOptionsCasse(ActionEvent actionEvent) {
        boxcasse.setSelected(true);
        labelcasse.setDisable(false);
        boxcassemaj.setDisable(false);
        boxcassemin.setDisable(false);
    }

    public void afficheOptionsTexte(ActionEvent actionEvent) {
        boxtexte.setSelected(true);
        labeltexte.setDisable(false);
        boxtxtblanc.setDisable(false);
        boxtxtnoir.setDisable(false);
        boxtxtrouge.setDisable(false);
    }

    public void applyRedFontColor(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre couleur) :
        boxtxtrouge.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de même catégorie :
        boxtxtnoir.setSelected(false);
        boxtxtblanc.setSelected(false);

        //et 2. j'applique le style choisi :
        resultat.setStyle(resultat.getStyle() + "-fx-text-fill: red;");
    }

    public void applyBlackFontColor(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre couleur) :
        boxtxtnoir.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de même catégorie :
        boxtxtrouge.setSelected(false);
        boxtxtblanc.setSelected(false);

        //et 2. j'applique le style choisi :
        resultat.setStyle(resultat.getStyle() + "-fx-text-fill: black;");
    }

    public void applyWhiteFontColor(ActionEvent actionEvent) {
        //empêcher l'utilisateur de décocher la case (seule possibilité: cocher une autre couleur) :
        boxtxtblanc.setSelected(true);
        //si checkbox cochée : 1. je décoche autres box de même catégorie :
        boxtxtnoir.setSelected(false);
        boxtxtrouge.setSelected(false);

        //et 2. j'applique le style choisi :
        resultat.setStyle(resultat.getStyle() + "-fx-text-fill: white;");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
