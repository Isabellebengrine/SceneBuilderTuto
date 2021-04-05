package org.isa.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableviewController implements Initializable {

    @FXML
    private TableView<Client> lst_clients;
    @FXML
    private TableColumn<Client, String> col_prenom;
    @FXML
    private TableColumn<Client, String> col_nom;
    @FXML
    private TableColumn<Client, String> col_ville;
    public Label labelTitre;
    public Label labelPrenom;
    public Label labelVille;
    public Label labelNom;
    public TextField txtPrenom;
    public TextField txtNom;
    public TextField txtVille;
    public Button btnSauver;
    public Button btnAnnuler;
    public Button btnSupprimer;
    public Button btnBack;

    //pour stocker clients dans une ObservableList qui permettra de remplir TableView
    ObservableList<Client> model = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialisation du modèle
        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));

        //On rend le tableau non-éditable
        lst_clients.setEditable(false);

        // Jonction du tableau avec les données
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));

        // On indique au TableView quelle modèle observer pour trouver les données
        lst_clients.setItems(model);
    }

    public void save(ActionEvent actionEvent) {
        Client nvoclient = new Client(txtPrenom.getText(), txtNom.getText(), txtVille.getText());
        model.add(nvoclient);
    }

    public void cancel(ActionEvent actionEvent) {
        txtNom.clear();
        txtPrenom.clear();
        txtVille.clear();
    }

    public void delete(ActionEvent actionEvent) {

        //supprimer l'enregistrement sélectionné du tableau :
        model.remove(lst_clients.getSelectionModel().getSelectedIndex());
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
