package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuExcluirCategoriaController {

    @FXML
    private Text Categoria;

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
    private Label categoriaInexistente;

    @FXML
    private Text digiteID;

    @FXML
    private Label excluirNao;

    @FXML
    private Label excluirSim;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBusca;

    @FXML
    private Label IdInvalido;

    @FXML
    private Label categoriaAssociada;

    @FXML
    private Button voltar;

    @FXML
    public void initialize() {
        IdInvalido.setVisible(false);
        categoriaInexistente.setVisible(false);
        buttonExcluir.setVisible(false);
        buttonEscolha.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(false);
        categoriaAssociada.setVisible(false);
    }

    @FXML
    void buscarCategoria(ActionEvent event) {
        String ID = txtBusca.getText();
        categoriaAssociada.setVisible(false);

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
                buttonExcluir.setVisible(true);
                Categoria categoriaEncontrada = (Categoria) categoriasNoh.getObjeto();
                txtArea.setText(categoriaEncontrada.toString());
            } else {
                categoriaInexistente.setVisible(true);
                IdInvalido.setVisible(false);
            }
        }
    }

    @FXML
    void confirmarExcluir(ActionEvent event) {
        String busca = txtBusca.getText();
        Arquivo.removerArquivoCSV("lib\\Categorias.csv", busca, 0);
        buttonEscolha.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(true);
    }

    @FXML
    void excluirCategoria(ActionEvent event) {
        String ID = txtBusca.getText();
        Boolean Associado = false;
        String lista = "";
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }

        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        Noh categoriaNoh = listaCategorias.busca(Integer.parseInt(ID));
        if (categoriaNoh != null) {
            Categoria Objeto = (Categoria) categoriaNoh.getObjeto();
            LDE veiculosLDE = (LDE) listaVeiculos;
            Noh veiculosNoh = veiculosLDE.getInicio();
            while (veiculosNoh != null) {
                Veiculo veiculoAtual = (Veiculo) veiculosNoh.getObjeto();
                if (veiculoAtual.getCategoria().getIdCategoria() == Objeto.getIdCategoria()) {
                    lista += veiculoAtual.toString() + "\n" + linhaTracejada + "\n";
                    txtArea.setText(lista);
                    categoriaAssociada.setVisible(true);
                    Associado = true;
                }
                veiculosNoh = veiculosNoh.getProximo();
            }
            if (Associado == false) {
                IdInvalido.setVisible(false);
                categoriaAssociada.setVisible(false);
                categoriaInexistente.setVisible(false);
                txtBusca.setVisible(false);
                txtArea.setVisible(false);
                Categoria.setVisible(false);
                digiteID.setVisible(false);
                buttonBuscar.setVisible(false);
                buttonExcluir.setVisible(false);
                buttonEscolha.setVisible(true);
            }
                
        }
    }

    @FXML
    void negarExcluir(ActionEvent event) {
        buttonEscolha.setVisible(false);
        excluirNao.setVisible(true);
        excluirSim.setVisible(false);
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
