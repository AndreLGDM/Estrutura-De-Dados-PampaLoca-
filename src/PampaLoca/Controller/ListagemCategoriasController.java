package PampaLoca.Controller;

import PampaLoca.LDE;
import PampaLoca.Noh;

import java.io.IOException;

import PampaLoca.Arquivo;
import PampaLoca.ILista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ListagemCategoriasController {

    @FXML
    private TextArea txtAreaCategorias;

    @FXML
    private Button buttonOK;

    String lista = "";

    @FXML
    public void initialize() {

        txtAreaCategorias.setStyle("-fx-text-fill: #FF69B4;");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaCategorias.estahVazia()) {
            txtAreaCategorias.setText("A lista está vazia.");
            return;
        }
        LDE listaCategoriasAtt = (LDE) listaCategorias;
        Noh atual = listaCategoriasAtt.getInicio();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getProximo();
        }
        txtAreaCategorias.setText(lista);
    }

    @FXML
    void voltarMenuCategorias(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PampaLoca/FMXL/MenuCategorias.fxml"));
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}