package PampaLoca.Controller;

import java.io.IOException;

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
    }

    @FXML
    void GerarVeiculo(ActionEvent event) throws IOException {
        String Placa = txtPlaca.getText();
        String Modelo = txtModelo.getText();
        String Marca = txtMarca.getText();
        String Ano = txtAno.getText();
        String Potencia = txtPotencia.getText();
        String Lugares = txtLugares.getText();
        String Categoria = txtCategoria.getText();

        if (!Placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || !Placa.matches("[A-Z]{3}-\\d{4}"))
            placaInvalida.setVisible(true);
        else
            placaInvalida.setVisible(false);

        if (!Categoria.matches("[0-9]+"))
            categoriaInvalida.setVisible(true);
        else
            categoriaInvalida.setVisible(false);

        if (!Ano.matches("[0-9]+"))
            anoInvalido.setVisible(true);
        else
            anoInvalido.setVisible(false);

        if (!Potencia.matches("[0-9]+"))
            potenciaInvalida.setVisible(true);
        else
            potenciaInvalida.setVisible(false);

        if (!Lugares.matches("[0-9]+"))
            quantidadeInvalida.setVisible(true);
        else
            quantidadeInvalida.setVisible(false);

        if ((Placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || !Placa.matches("[A-Z]{3}-\\d{4}"))
                && Categoria.matches("[0-9]+") && Ano.matches("[0-9]+") && Potencia.matches("[0-9]+")
                && Lugares.matches("[0-9]+")) {

            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh categoria;
            categoria = listaCategorias.busca(Integer.parseInt(Categoria));
            if (categoria != null) {
                Categoria categoriaObjeto = (Categoria) categoria.getObjeto();
                Veiculo veiculoGerado = new Veiculo(Placa, Modelo, Marca, Integer.parseInt(Ano),
                        Integer.parseInt(Potencia), Integer.parseInt(Lugares), categoriaObjeto);
                listaVeiculos.insereFim(veiculoGerado);
                Arquivo.gravarArquivoCSV(veiculoGerado);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuVeiculos.fxml"));
                Parent root = fxmlLoader.load();
                Scene tela = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(tela);
                root.setStyle("-fx-background-color: LIGHTBLUE");
                stage.show();
            } else {
                categoriaInvalida.setVisible(true);
            }
        }

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
