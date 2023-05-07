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

public class MenuEditarCategoriaController {

    @FXML
    private Text Categoria;

    @FXML
    private Label IdInvalido;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Button buttonEditar;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonSalvar2;

    @FXML
    private MenuButton buttonEscolha;

    @FXML
    private MenuItem editarID;

    @FXML
    private Label categoriaInexistente;

    @FXML
    private Label idModificado;

    @FXML
    private Label nomeModificado;

    @FXML
    private Text digiteID;

    @FXML
    private Text idNovo;

    @FXML
    private Text nomeNovo;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBusca;

    @FXML
    private TextField txtIdNovo;

    @FXML
    private TextField txtNomeNovo;

    @FXML
    private Button voltar;

    @FXML
    public void initialize() {
        categoriaInexistente.setVisible(false);
        IdInvalido.setVisible(false);
        buttonEditar.setVisible(false);
        buttonEscolha.setVisible(false);
        buttonSalvar.setVisible(false);
        txtIdNovo.setVisible(false);
        idNovo.setVisible(false);
        nomeNovo.setVisible(false);
        buttonSalvar2.setVisible(false);
        txtNomeNovo.setVisible(false);
        nomeModificado.setVisible(false);
        idModificado.setVisible(false);
    }

    @FXML
    void buscarCategoria(ActionEvent event) {
        String ID = txtBusca.getText();

        if (!ID.matches("[0-9]+")) {
            categoriaInexistente.setVisible(false);
            IdInvalido.setVisible(true);
        } else {
            IdInvalido.setVisible(false);
        }

        if (ID.matches("[0-9]+")) {
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh categoriasNoh = listaCategorias.busca(Integer.parseInt(ID));
            if (categoriasNoh != null) {
                categoriaInexistente.setVisible(false);
                buttonEditar.setVisible(true);
                Categoria categoriaEncontrada = (Categoria) categoriasNoh.getObjeto();
                txtArea.setText(categoriaEncontrada.toString());
            } else {
                categoriaInexistente.setVisible(true);
                buttonEditar.setVisible(false);
                IdInvalido.setVisible(false);
            }
        }
    }

    @FXML
    void editarCategoria(ActionEvent event) {
        txtArea.setVisible(false);
        txtBusca.setVisible(false);
        buttonBuscar.setVisible(false);
        Categoria.setVisible(false);
        digiteID.setVisible(false);
        buttonEditar.setVisible(false);
        buttonEscolha.setVisible(true);
    }

    @FXML
    void editarID(ActionEvent event) {
        buttonSalvar.setVisible(true);
        txtIdNovo.setVisible(true);
        idNovo.setVisible(true);
        buttonEditar.setVisible(false);
    }

    @FXML
    void editarNome(ActionEvent event) {
        buttonSalvar2.setVisible(true);
        txtNomeNovo.setVisible(true);
        nomeNovo.setVisible(true);
        buttonEditar.setVisible(false);
    }

    @FXML
    void editaCSV2(ActionEvent event) throws InterruptedException {
        String busca = txtBusca.getText();
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        Noh categoriaNoh = listaCategorias.busca(Integer.parseInt(busca));
        if (categoriaNoh != null) {
            Categoria Objeto = (Categoria) categoriaNoh.getObjeto();
            String nomeAntigo = Objeto.getNomeCategoria().toString();
            String nome = txtNomeNovo.getText();
            Arquivo.editarArquivoCSV("lib\\Categorias.csv",busca,0, nomeAntigo, 1, nome, 1);
        }
        buttonSalvar2.setVisible(false);
        txtNomeNovo.setVisible(false);
        nomeNovo.setVisible(false);
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
    void editaCSV(ActionEvent event) throws InterruptedException {
        String idAntigo = txtBusca.getText();
        String iD = txtIdNovo.getText();
        if (!iD.matches("[0-9]+")) {
            IdInvalido.setVisible(true);
        } else {
            IdInvalido.setVisible(false);
            Arquivo.editarArquivoCSV("lib\\Categorias.csv",idAntigo,0, idAntigo, 0, iD, 0);
            Arquivo.editarArquivoCSV("lib\\Veiculos.csv",idAntigo,6, idAntigo, 6, iD, 6);
            buttonSalvar.setVisible(false);
            txtIdNovo.setVisible(false);
            idNovo.setVisible(false);
            idModificado.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                idModificado.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        }
    }

    @FXML
    void voltarMenuLocacoes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuCategorias.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

}
