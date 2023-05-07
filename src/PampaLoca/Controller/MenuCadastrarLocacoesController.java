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
    private Label clienteInexistente;

    @FXML
    private Label veiculoInexistente;

    @FXML
    private Label clienteLocado;

    @FXML
    private Label veiculoLocado;

    @FXML
    private DatePicker data1;

    @FXML
    private DatePicker data2;

    @FXML
    private Label placaInvalida;

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
        placaInvalida.setVisible(false);
        clienteInexistente.setVisible(false);
        clienteLocado.setVisible(false);
        veiculoInexistente.setVisible(false);
        veiculoLocado.setVisible(false);
    }

    @FXML
    void GerarLocacao(ActionEvent event) throws IOException {

        Cliente clienteObjeto = null;
        Veiculo veiculoObjeto = null;
        ;
        String cpf = txtCPF.getText();
        String placa = txtPlaca.getText();
        Boolean clienteEncontrado = false;
        Boolean veiculoEncontrado = false;

        clienteLocado.setVisible(false);
        if (!cpf.matches("[0-9]+")) {
            cpfInvalido.setVisible(true);
            clienteInexistente.setVisible(false);
        } else {
            cpfInvalido.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh Clientes;
            Clientes = listaClientes.busca(cpf);
            if (Clientes != null) {
                Cliente clienteAchado = (Cliente) Clientes.getObjeto();
                clienteObjeto = clienteAchado;
                Noh locacoes;
                LDE listaATT = (LDE) listaLocacoes;
                locacoes = listaATT.getInicio();
                Locacao locExistente = (Locacao) locacoes.getObjeto();
                while (locacoes != null) {
                    if (locExistente.getCliente().getCNH().equals(clienteAchado.getCNH())) {
                        clienteLocado.setVisible(true);
                        clienteEncontrado = true;
                        break;
                    }
                    locacoes = locacoes.getProximo();
                }
            } else {
                clienteInexistente.setVisible(true);
            }
        }
        if (placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || placa.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh veiculoNoh;
            veiculoNoh = listaVeiculos.busca(placa);

            if (veiculoNoh != null) {
                Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                veiculoObjeto = Objeto;
                LDE locacaoLDE = (LDE) listaLocacoes;
                Noh locacaoNoh = locacaoLDE.getInicio();
                while (locacaoNoh != null) {
                    Locacao locacaoAtual = (Locacao) locacaoNoh.getObjeto();
                    if (locacaoAtual.getVeiculo().getModeloVeiculo().equals(Objeto.getModeloVeiculo())) {
                        veiculoLocado.setVisible(true);
                        veiculoEncontrado = true;
                        break;
                    }
                    locacaoNoh = locacaoNoh.getProximo();
                }
            } else
                veiculoInexistente.setVisible(true);
        } else
            placaInvalida.setVisible(true);

        if (clienteEncontrado == false && veiculoEncontrado == false) {
            Locacao locacaoGerada = new Locacao(clienteObjeto, veiculoObjeto);
            locacaoGerada.setDataDeRetirada(data1.getValue());
            locacaoGerada.setDataDeDevolucao(data2.getValue());
            Arquivo.gravarArquivoCSV(locacaoGerada);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuLocacoes.fxml"));
            Parent root = fxmlLoader.load();
            Scene tela = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(tela);
            root.setStyle("-fx-background-color: LIGHTBLUE");
            stage.show();
        }
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
