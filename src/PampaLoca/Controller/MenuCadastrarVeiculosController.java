package PampaLoca.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuCadastrarVeiculosController {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtLugares;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtPotencia;

    @FXML
    private Button voltar;

    @FXML
    void GerarVeiculo(ActionEvent event) throws IOException{
        String placa = txtPlaca.getText();
        String Modelo = txtModelo.getText();
        String Marca = txtMarca.getText();
        String Ano = txtAno.getText();
        String Potencia = txtPotencia.getText();
        String Lugares = txtLugares.getText();
        String Categoria = txtCategoria.getText();

        
    }

    @FXML
    void voltarMenuVeiculos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuVeiculos.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}
