package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuCadastrarLocacoesController {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Label cpfInvalido;

    @FXML
    private DatePicker data1;

    @FXML
    private DatePicker data2;

    @FXML
    private Label placaInvalido;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtValor;

    @FXML
    private Button voltar;

    @FXML
    public void initialize() {
        cpfInvalido.setVisible(false);
        placaInvalido.setVisible(false);
    }

    @FXML
    void GerarLocacao(ActionEvent event) throws IOException {

        String CPF = txtCPF.getText();
        String placa = txtPlaca.getText();

        if (!CPF.matches("[0-9]+"))
        cpfInvalido.setVisible(true);
        else
        cpfInvalido.setVisible(false);

        if (placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || placa.matches("[A-Z]{3}-\\d{4}")) 
        placaInvalido.setVisible(true);
        else 
        placaInvalido.setVisible(false);

        if(CPF.matches("[0-9]+") && (placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || placa.matches("[A-Z]{3}-\\d{4}"))){
            
        Veiculo veiculoObjeto = null;
        Cliente clienteObjeto = null;
        ILista Veiculos = new LDE();
        ILista Clientes = new LDE();
        ILista Locacoes = new LDE();
        ILista Categorias = new LDE();
        Arquivo.lerArquivoCSV(Veiculos, Clientes, Locacoes, Categorias);

        Noh Veiculo;
        Veiculo = Veiculos.busca(placa);
        veiculoObjeto = (Veiculo) Veiculo.getObjeto();
   

        Noh Cliente;
        Cliente = Clientes.busca(CPF);
        clienteObjeto = (Cliente) Cliente.getObjeto();
 
        
        Locacao locacaoGerada = new Locacao(clienteObjeto, veiculoObjeto);
        Arquivo.gravarArquivoCSV(locacaoGerada);
        Locacoes.insereFim(locacaoGerada);
        }


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuLocacoes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

    @FXML
    void voltarMenuLocacoes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuLocacoes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

}
