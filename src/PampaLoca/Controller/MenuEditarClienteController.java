package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.*;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuEditarClienteController {

    @FXML
    private Text TelefoneNovo;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Button buttonEditarCliente;

    @FXML
    private MenuButton buttonEscolha;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonSalvar2;

    @FXML
    private Button buttonSalvar3;

    @FXML
    private Button buttonSalvar4;

    @FXML
    private Text cliente;

    @FXML
    private Label clienteInexistente;

    @FXML
    private Label cnhModificada;

    @FXML
    private Text cnhNova;

    @FXML
    private Label cpfInvalido;

    @FXML
    private Label telefoneInvalido;

    @FXML
    private Label cnhInvalida;

    @FXML
    private Label cpfModificado;

    @FXML
    private Text cpfNovo;

    @FXML
    private Text digiteCPF;

    @FXML
    private MenuItem editarCNH;

    @FXML
    private MenuItem editarCPF;

    @FXML
    private MenuItem editarNome;

    @FXML
    private MenuItem editarTelefone;

    @FXML
    private Label nomeModificado;

    @FXML
    private Text nomeNovo;

    @FXML
    private Label telefoneModificado;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBusca;

    @FXML
    private TextField txtCpfNovo;

    @FXML
    private TextField txtCnhNova;

    @FXML
    private TextField txtNomeNovo;

    @FXML
    private TextField txtTelefoneNovo;

    @FXML
    private Button voltar;

    @FXML
    public void initialize() {
        clienteInexistente.setVisible(false);
        cpfInvalido.setVisible(false);
        cnhInvalida.setVisible(false);
        telefoneInvalido.setVisible(false);
        buttonEditarCliente.setVisible(false);
        buttonEscolha.setVisible(false);
        buttonSalvar.setVisible(false);
        buttonSalvar2.setVisible(false);
        buttonSalvar3.setVisible(false);
        buttonSalvar4.setVisible(false);
        nomeNovo.setVisible(false);
        cnhNova.setVisible(false);
        cpfNovo.setVisible(false);
        TelefoneNovo.setVisible(false);
        txtNomeNovo.setVisible(false);
        txtCpfNovo.setVisible(false);
        txtCnhNova.setVisible(false);
        txtTelefoneNovo.setVisible(false);
        nomeModificado.setVisible(false);
        cpfModificado.setVisible(false);
        cnhModificada.setVisible(false);
        telefoneModificado.setVisible(false);
    }

    @FXML
    void buscarCliente(ActionEvent event) {
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
                buttonEditarCliente.setVisible(true);
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
    void editaCSV(ActionEvent event) {
        String cpfAntigo = txtBusca.getText();
        String cpf = txtCpfNovo.getText();
        if (!cpf.matches("[0-9]+")) {
            cpfInvalido.setVisible(true);
        } else {
            cpfInvalido.setVisible(false);
            Arquivo.editarArquivoCSV("lib\\Clientes.csv",cpfAntigo,3, cpfAntigo, 3, cpf, 3);
            cpfNovo.setVisible(false);
            txtCpfNovo.setVisible(false);
            buttonSalvar.setVisible(false);
            cpfModificado.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                cpfModificado.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        }
    }

    @FXML
    void editaCSV2(ActionEvent event) {
        String busca = txtBusca.getText();
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        Noh clienteNoh = listaClientes.busca(busca);
        if (clienteNoh != null) {
            Cliente Objeto = (Cliente) clienteNoh.getObjeto();
            String nomeAntigo = Objeto.getNome().toString();
            String nome = txtNomeNovo.getText();
            Arquivo.editarArquivoCSV("lib\\Clientes.csv",busca,3, nomeAntigo, 0, nome, 0);
            Arquivo.editarArquivoCSV("lib\\Locações.csv",nomeAntigo,1, nomeAntigo, 1, nome, 1);
        }
        nomeNovo.setVisible(false);
        txtNomeNovo.setVisible(false);
        buttonSalvar2.setVisible(false);
        nomeModificado.setVisible(true);
        Task<Void> pausaTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(3000);
                return null;
            }
        };
        pausaTask.setOnSucceeded(e -> {
            nomeModificado.setVisible(false);
            buttonEscolha.setVisible(true);
        });
        new Thread(pausaTask).start();
    }

    @FXML
    void editaCSV3(ActionEvent event) {
        String busca = txtBusca.getText();
        String cnh = txtCnhNova.getText();
        if (!cnh.matches("[0-9]+")) {
            cnhInvalida.setVisible(true);
        } else {
            cnhInvalida.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh clienteNoh = listaClientes.busca(busca);
            if (clienteNoh != null) {
                Cliente Objeto = (Cliente) clienteNoh.getObjeto();
                String cnhAntiga = Objeto.getCNH().toString();
                Arquivo.editarArquivoCSV("lib\\Clientes.csv",busca,3, cnhAntiga, 1, cnh, 1);
                Arquivo.editarArquivoCSV("lib\\Locações.csv",cnhAntiga,2, cnhAntiga, 2, cnh, 2);
            }
            cnhNova.setVisible(false);
            txtCnhNova.setVisible(false);
            buttonSalvar3.setVisible(false);
            cnhModificada.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                cnhModificada.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        }
    }

    @FXML
    void editaCSV4(ActionEvent event) {
        String busca = txtBusca.getText();
        String telefone = txtTelefoneNovo.getText();
        if (!telefone.matches("[0-9]+")) {
            telefoneInvalido.setVisible(true);
        } else {
            telefoneInvalido.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh clienteNoh = listaClientes.busca(busca);
            if (clienteNoh != null) {
                Cliente Objeto = (Cliente) clienteNoh.getObjeto();
                String telefoneAntigo = Objeto.getTelefone().toString();
                Arquivo.editarArquivoCSV("lib\\Clientes.csv",busca,3, telefoneAntigo, 2, telefone, 2);
            }
            TelefoneNovo.setVisible(false);
            txtTelefoneNovo.setVisible(false);
            buttonSalvar4.setVisible(false);
            telefoneModificado.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                telefoneModificado.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        }
    }

    @FXML
    void editarCNH(ActionEvent event) {
        buttonSalvar3.setVisible(true);
        cnhNova.setVisible(true);
        txtCnhNova.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarCPF(ActionEvent event) {
        buttonSalvar.setVisible(true);
        cpfNovo.setVisible(true);
        txtCpfNovo.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarCliente(ActionEvent event) {
        cliente.setVisible(false);
        digiteCPF.setVisible(false);
        buttonBuscar.setVisible(false);
        buttonEditarCliente.setVisible(false);
        txtBusca.setVisible(false);
        txtArea.setVisible(false);
        buttonEscolha.setVisible(true);
    }

    @FXML
    void editarNome(ActionEvent event) {
        nomeNovo.setVisible(true);
        txtNomeNovo.setVisible(true);
        buttonSalvar2.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarTelefone(ActionEvent event) {
        buttonSalvar4.setVisible(true);
        TelefoneNovo.setVisible(true);
        txtTelefoneNovo.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void voltarMenuLocacoes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuClientes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

}
