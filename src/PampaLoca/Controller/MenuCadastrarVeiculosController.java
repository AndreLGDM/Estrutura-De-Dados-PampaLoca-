package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    void GerarVeiculo(ActionEvent event) throws IOException{
        String placa = txtPlaca.getText();
        String Modelo = txtModelo.getText();
        String Marca = txtMarca.getText();
        String Ano = txtAno.getText();
        String Potencia = txtPotencia.getText();
        String Lugares = txtLugares.getText();
        String Categoria = txtCategoria.getText();

        
    }

}
