package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.Arquivo;
import PampaLoca.Categoria;
import PampaLoca.ILista;
import PampaLoca.LDE;
import PampaLoca.Noh;
import PampaLoca.Veiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuCadastrarVeiculosController {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Label categoriaInvalida;

    @FXML
    private Label categoriaInexistente;

    @FXML
    private Label anoInvalido;

    @FXML
    private Label placaInvalida;

    @FXML
    private Label potenciaInvalida;

    @FXML
    private Label quantidadeInvalida;

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
    public void initialize() {
        anoInvalido.setVisible(false);
        categoriaInvalida.setVisible(false);
        placaInvalida.setVisible(false);
        potenciaInvalida.setVisible(false);
        quantidadeInvalida.setVisible(false);
        categoriaInexistente.setVisible(false);
    }

    @FXML
    void GerarVeiculo(ActionEvent event) throws IOException {
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String marca = txtMarca.getText();
        String ano = txtAno.getText();
        String potencia = txtPotencia.getText();
        String lugares = txtLugares.getText();
        String categoria = txtCategoria.getText();

        if (placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}")) {
            placaInvalida.setVisible(false);
        } else if (placa.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(false);
        } else {
            placaInvalida.setVisible(true);
        }
        if (!categoria.matches("[0-9]+"))
            categoriaInvalida.setVisible(true);
        else
            categoriaInvalida.setVisible(false);

        if (!ano.matches("[0-9]+"))
            anoInvalido.setVisible(true);
        else
            anoInvalido.setVisible(false);

        if (!potencia.matches("[0-9]+"))
            potenciaInvalida.setVisible(true);
        else
            potenciaInvalida.setVisible(false);

        if (!lugares.matches("[0-9]+"))
            quantidadeInvalida.setVisible(true);
        else
            quantidadeInvalida.setVisible(false);

        if ((placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || placa.matches("[A-Z]{3}-\\d{4}"))
                && categoria.matches("[0-9]+") && ano.matches("[0-9]+") && potencia.matches("[0-9]+")
                && lugares.matches("[0-9]+")) {

            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh categoriaNoh;
            categoriaNoh = listaCategorias.busca(Integer.parseInt(categoria));
            if (categoriaNoh != null) {
                Categoria categoriaObjeto = (Categoria) categoriaNoh.getObjeto();
                Veiculo veiculoGerado = new Veiculo(placa, modelo, marca, Integer.parseInt(ano),
                        Integer.parseInt(potencia), Integer.parseInt(lugares), categoriaObjeto);
                listaVeiculos.insereFim(veiculoGerado);
                Arquivo.gravarArquivoCSV(veiculoGerado);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuVeiculos.fxml"));
                Parent root = fxmlLoader.load();
                Scene tela = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(tela);
                root.setStyle("-fx-background-color: LIGHTBLUE");
                stage.show();
            } else {
                categoriaInexistente.setVisible(true);
                categoriaInvalida.setVisible(false);
            }
        }

    }

    @FXML
    void voltarMenuVeiculos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuVeiculos.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}
