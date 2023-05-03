package PampaLoca.Controller;

import PampaLoca.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MenuExcluirLocacaoController {

    @FXML
    private Text Cliente;

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
    private Label placaInvalida;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBuscaPlaca;

    @FXML
    private Button voltar;

    @FXML
    public void initialize() {
        buttonEscolha.setVisible(false);
        buttonExcluir.setVisible(false);
        veiculoInexistente.setVisible(false);
        placaInvalida.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(false);
    }

    @FXML
    void buscarCliente(ActionEvent event) {
        String busca = txtBuscaPlaca.getText();

        if (!busca.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") && !busca.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(true);
        } else {
            placaInvalida.setVisible(false);

            if (busca.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || busca.matches("[A-Z]{3}-\\d{4}")) {
                placaInvalida.setVisible(false);
                ILista listaVeiculos = new LDE();
                ILista listaCategorias = new LDE();
                ILista listaClientes = new LDE();
                ILista listaLocacoes = new LDE();
                Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
                Noh Veiculos;
                Veiculos = listaVeiculos.busca(busca);
                boolean veiculoEncontrado = false;
                if (Veiculos != null) {
                    String locacao = "";
                    veiculoInexistente.setVisible(false);
                    buttonExcluir.setVisible(true);
                    Veiculo veiculoAchado = (Veiculo) Veiculos.getObjeto();
                    Noh locacoes;
                    LDE listaATT = (LDE) listaLocacoes;
                    locacoes = listaATT.getInicio();
                    Locacao locExistente;
                    while (locacoes != null) {
                        locExistente = (Locacao) locacoes.getObjeto();
                        if (locExistente.getVeiculo().getPlacaVeiculo().equals(veiculoAchado.getPlacaVeiculo())) {
                            veiculoEncontrado = true;
                            break;
                        } else {
                            locacao = locExistente.toString();
                            txtArea.setText(locacao);
                        }
                        locacoes = locacoes.getProximo();
                    }
                    if (veiculoEncontrado == false) {
                        veiculoInexistente.setVisible(true);
                        placaInvalida.setVisible(false);
                    } 
                }
            }
        }
    }

    @FXML
    void confirmarExcluir(ActionEvent event) {

    }

    @FXML
    void excluirCliente(ActionEvent event) {

    }

    @FXML
    void negarExcluir(ActionEvent event) {

    }

    @FXML
    void voltarMenuLocacoes(ActionEvent event) {

    }

}
