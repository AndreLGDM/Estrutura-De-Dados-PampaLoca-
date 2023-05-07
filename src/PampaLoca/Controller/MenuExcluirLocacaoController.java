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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuExcluirLocacaoController {

    @FXML
    private Text Locacao;

    @FXML
    private Button buttonBuscar;

    @FXML
    private SplitMenuButton buttonEscolha;

    @FXML
    private Button buttonExcluir;

    @FXML
    private MenuItem buttonNão;

    @FXML
    private MenuItem buttonSim;

    @FXML
    private Text digitePlaca;

    @FXML
    private Label excluirNao;

    @FXML
    private Label excluirSim;

    @FXML
    private Label veiculoInexistente;

    @FXML
    private Label txtNaoEncontrada;

    @FXML
    private Label placaInvalida;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBuscaPlaca;

    @FXML
    private Button voltar;

    String chave = "";

    @FXML
    public void initialize() {
        buttonEscolha.setVisible(false);
        txtNaoEncontrada.setVisible(false);
        buttonExcluir.setVisible(false);
        veiculoInexistente.setVisible(false);
        placaInvalida.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(false);
    }

    @FXML
    void buscarCliente(ActionEvent event) {
        String busca = txtBuscaPlaca.getText();

        if (busca.matches("[A-Z]{3}-\\d[A-Z]\\d{2}")) {
            placaInvalida.setVisible(false);
            buttonExcluir.setVisible(true);
        } else if (busca.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(false);
            buttonExcluir.setVisible(true);
        } else {
            buttonExcluir.setVisible(false);
            placaInvalida.setVisible(true);
        }

        if (busca.matches("[A-Z]{3}-\\d[A-Z]\\d{2}")) {
            placaInvalida.setVisible(false);
            buttonExcluir.setVisible(true);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh veiculoNoh;
            veiculoNoh = listaVeiculos.busca(busca);
            if (veiculoNoh != null) {
                Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                LDE locacaoLDE = (LDE) listaLocacoes;
                Noh locacaoNoh = locacaoLDE.getInicio();
                while (locacaoNoh != null) {
                    Locacao locacaoAtual = (Locacao) locacaoNoh.getObjeto();
                    if (locacaoAtual.getVeiculo().getModeloVeiculo().equals(Objeto.getModeloVeiculo())) {
                        txtArea.setText(locacaoAtual.toString());
                        chave = locacaoAtual.getVeiculo().getModeloVeiculo().toString();
                        break;
                    }
                    locacaoNoh = locacaoNoh.getProximo();
                }
                if (locacaoNoh == null) {
                    txtArea.setText("");
                    txtNaoEncontrada.setVisible(true);

                }
            } else {
                veiculoInexistente.setVisible(true);
            }

        } else if (busca.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(false);
            buttonExcluir.setVisible(true);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh veiculoNoh;
            veiculoNoh = listaVeiculos.busca(busca);
            if (veiculoNoh != null) {
                Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                LDE locacaoLDE = (LDE) listaLocacoes;
                Noh locacaoNoh = locacaoLDE.getInicio();
                while (locacaoNoh != null) {
                    Locacao locacaoAtual = (Locacao) locacaoNoh.getObjeto();
                    if (locacaoAtual.getVeiculo().getModeloVeiculo().equals(Objeto.getModeloVeiculo())) {
                        txtArea.setText(locacaoAtual.toString());
                        chave = locacaoAtual.getVeiculo().getModeloVeiculo().toString();
                        break;
                    }
                    locacaoNoh = locacaoNoh.getProximo();
                }
                if (locacaoNoh == null) {
                    txtArea.setText("");
                    txtNaoEncontrada.setVisible(true);

                }
            } else {
                veiculoInexistente.setVisible(true);
            }
        }

    }

    @FXML
    void confirmarExcluir(ActionEvent event) {
        Arquivo.removerArquivoCSV("lib\\Locações.csv", chave, 0);
        buttonEscolha.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(true);
    }

    @FXML
    void excluirCliente(ActionEvent event) {
        buttonBuscar.setVisible(false);
        txtBuscaPlaca.setVisible(false);
        Locacao.setVisible(false);
        txtArea.setVisible(false);
        buttonExcluir.setVisible(false);
        Locacao.setVisible(false);
        digitePlaca.setVisible(false);
        veiculoInexistente.setVisible(false);
        placaInvalida.setVisible(false);
        buttonEscolha.setVisible(true);
    
    }

    @FXML
    void negarExcluir(ActionEvent event) {
        buttonEscolha.setVisible(false);
        excluirNao.setVisible(true);
        excluirSim.setVisible(false);
    }

    @FXML
    void voltarMenuLocacoes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuLocacoes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}
