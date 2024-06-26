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

public class MenuClientesController {

    @FXML
    private Button buttonListarClientes;

    @FXML
    private Button buttonCriarCliente;

    @FXML
    private Button buttonEditarCliente;

    @FXML
    private Button voltar;

    @FXML
    private Button buttonExcluirCliente;

    @FXML
    void editarClientes(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuEditarClientes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
    
    @FXML
    void apagarCliente(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuExcluirCliente.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

    @FXML
    void irCadastroCliente(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuCadastrarClientes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

    @FXML
    void ListarClientes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/ListagemClientes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuPrincipal.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}