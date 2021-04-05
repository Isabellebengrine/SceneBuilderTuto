package org.isa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AdditionneurController {
    public Button btnBack;
    @FXML
    private TextArea resultat;
    @FXML
    private Button chiffre1;
    @FXML
    private Button chiffre2;
    @FXML
    private Button calculer;
    @FXML
    private Button vider;
    @FXML
    private Button chiffre0;
    @FXML
    private Button chiffre3;
    @FXML
    private Button chiffre4;
    @FXML
    private Button chiffre6;
    @FXML
    private Button chiffre7;
    @FXML
    private Button chiffre8;
    @FXML
    private Button chiffre9;
    @FXML
    private Button chiffre5;

    public int total = 0;
    public ArrayList<Integer> inputs = new ArrayList<>();

    public void chiffre_click(ActionEvent actionEvent) {
        //pour effacer le total si on reclic sur un chiffre sans clic sur vider d'abord :
        total = 0;
        //afficher le chiffre cliqué :
        resultat.appendText(" + " + ((Button)actionEvent.getSource()).getText());
        //stocker valeur du bouton dans une variable int :
        int chiffre = Integer.parseInt(((Button)actionEvent.getSource()).getText());
        inputs.add(chiffre);
    }

    public void vider_click(ActionEvent actionEvent) {
        resultat.clear();
        inputs.clear();
        total = 0;
    }

    public void calculer_click(ActionEvent actionEvent) {
        for(int nb : inputs){
            total += nb;
        }
        resultat.setText(" + " + total);


        //méthode initiale - ne fonctionne pas - InvocationTargetException
        //vue par Germain 04/12 - pb split laisse premier terme = ""  à cause du premier " + "
        // donc essayé de l'enlever avec replaceFirst... mais tjs même problem donc essayer méthode Germain:
        //"à chaque clique tu affiche d'un côté et tu ajoute la valeur du bouton à une variable int"
/*        String saisie = resultat.getText();
        if (saisie != null) {
            saisie = saisie.replaceFirst(" + ", "");
            String[] nombres = saisie.split(" + ");
            int total = 0;
            for(String nombre : nombres){
                total = Integer.sum(total, Integer.parseInt(nombre));
            }
            resultat.setText(" + " + total);
        } else {
            // Nothing selected. Ne marche pas - why? 04/12 - 9h40
            resultat.setText("Please select a digit first.");
        }
*/

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
