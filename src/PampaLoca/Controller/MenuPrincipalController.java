package PampaLoca.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuPrincipalController {

    @FXML
    private Button buttonVeiculos;

    @FXML
    private Button buttonClientes;

    @FXML
    private Button buttonLocacoes;

    @FXML
    private Button buttonCategorias;

    @FXML
    void irMenuCategorias(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuCategorias.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

    @FXML
    void irMenuLocacoes(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuLocacoes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

    @FXML
    void irMenuVeiculos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PampaLoca/FXML/MenuVeiculos.fxml"));
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

    @FXML
    void irMenuClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PampaLoca/FXML/MenuClientes.fxml"));
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();

    }

}
