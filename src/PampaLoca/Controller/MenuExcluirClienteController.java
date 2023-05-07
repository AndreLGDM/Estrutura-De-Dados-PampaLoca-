package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;


public class MenuExcluirClienteController {

    @FXML
    private Label clienteInexistente;

    @FXML
    private Label cpfInvalido;

    @FXML
    private Label clienteLocado;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Text digiteCPF;

    @FXML
    private Text Cliente;

    @FXML
    private SplitMenuButton buttonEscolha;

    @FXML
    private Button buttonExcluir;

    @FXML
    private MenuItem buttonNão;

    @FXML
    private MenuItem buttonSim;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBusca;

    @FXML
    private Button voltar;

    @FXML
    private Label excluirNao;

    @FXML
    private Label excluirSim;

    @FXML
    public void initialize() {
        buttonEscolha.setVisible(false);
        buttonExcluir.setVisible(false);
        clienteInexistente.setVisible(false);
        cpfInvalido.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(false);
        clienteLocado.setVisible(false);
    }

    @FXML
    void buscarCliente(ActionEvent event) {
        clienteLocado.setVisible(false);
        String busca = txtBusca.getText();
        if (!busca.matches("[0-9]+")) {
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
            Clientes = listaClientes.busca(busca);
            if (Clientes != null) {
                String cliente = "";
                clienteInexistente.setVisible(false);
                buttonExcluir.setVisible(true);
                Cliente clienteEncontrado = (Cliente) Clientes.getObjeto();
                cliente = clienteEncontrado.toString();
                txtArea.setText(cliente);
            } else {
                clienteInexistente.setVisible(true);
                cpfInvalido.setVisible(false);
            }

        }

    }

    @FXML
    void confirmarExcluir(ActionEvent event) throws IOException {
        String busca = txtBusca.getText();
        Arquivo.removerArquivoCSV("lib\\Clientes.csv", busca, 3);
        buttonEscolha.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(true);
    }

    @FXML
    void excluirCliente(ActionEvent event) {
        String busca = txtBusca.getText();
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        Noh Clientes;
        Clientes = listaClientes.busca(busca);
        boolean clienteEncontrado = false;
        if (Clientes != null) {
            Cliente clienteAchado = (Cliente) Clientes.getObjeto();
            Noh locacoes;
            LDE listaATT = (LDE) listaLocacoes;
            locacoes = listaATT.getInicio();
            Locacao locExistente = (Locacao) locacoes.getObjeto();
            while (locacoes != null) {
                if (locExistente.getCliente().getCNH().equals(clienteAchado.getCNH())) {
                    clienteLocado.setVisible(true);
                    txtArea.setText(locExistente.toString());
                    clienteEncontrado = true;
                } else {
                    String cliente = clienteAchado.toString();
                    txtArea.setText(cliente);
                }
                locacoes = locacoes.getProximo();
            }

            if (clienteEncontrado == false) {
                buttonBuscar.setVisible(false);
                txtBusca.setVisible(false);
                digiteCPF.setVisible(false);
                Cliente.setVisible(false);
                txtArea.setVisible(false);
                buttonExcluir.setVisible(false);
                Cliente.setVisible(false);
                clienteInexistente.setVisible(false);
                cpfInvalido.setVisible(false);
                buttonEscolha.setVisible(true);
                clienteLocado.setVisible(false);
            }
        }
    }

    @FXML
    void negarExcluir(ActionEvent event) throws IOException {
        buttonEscolha.setVisible(false);
        excluirNao.setVisible(true);
        excluirSim.setVisible(false);
    }

    @FXML
    void voltarMenuClientes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuClientes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

}
