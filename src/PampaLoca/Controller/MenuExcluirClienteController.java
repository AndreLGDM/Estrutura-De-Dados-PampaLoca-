package PampaLoca.Controller;

import java.io.IOException;

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

public class MenuExcluirClienteController {

    @FXML
    private Label clienteInexistente;

    @FXML
    private Label cpfInvalido;

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
    public void initialize() {
        txtArea.setVisible(false);
        buttonEscolha.setVisible(false);
        buttonExcluir.setVisible(false);
        Cliente.setVisible(false);
        clienteInexistente.setVisible(false);
        cpfInvalido.setVisible(false);
    }

    @FXML
    void buscarCliente(ActionEvent event) {
        String busca = txtBusca.getText();
        if (!busca.matches("[0-9]+")) {
            cpfInvalido.setVisible(true);
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
                digiteCPF.setVisible(false);
                txtBusca.setVisible(false);
                buttonBuscar.setVisible(false);
                Cliente.setVisible(true);
                txtArea.setVisible(true);
                buttonExcluir.setVisible(true);
                Cliente clienteEncontrado = (Cliente) Clientes.getObjeto();
                cliente = clienteEncontrado.toString();
                txtArea.setText(cliente);
            } else {
                clienteInexistente.setVisible(true);
            }

        }

    }

    @FXML
    void confirmarExcluir(ActionEvent event) throws IOException {
        
        String busca = txtBusca.getText();
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        Noh Clientes;
        Clientes = listaClientes.busca(busca);
        if(Clientes != null){
        Arquivo.removerArquivoCSV("lib\\Clientes.csv", busca, 3);
        }else{
            clienteInexistente.setVisible(true);
        }
    }

    @FXML
    void excluirCliente(ActionEvent event) {
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
    }

    @FXML
    void negarExcluir(ActionEvent event) {

    }

}
