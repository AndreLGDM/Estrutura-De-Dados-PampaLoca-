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

public class ListagemVeiculosController {

    @FXML
    private TextArea txtAreaVeiculos;

    @FXML
    private Button buttonOK;

    @FXML
    private Button buttonInicio;

    @FXML
    private Button buttonFinal;

    String lista = "";

    @FXML
    public void initialize() {
        txtAreaVeiculos.setStyle("-fx-text-fill: BLACK");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaVeiculos.estahVazia()) {
            txtAreaVeiculos.setText("A lista está vazia.");
            return;
        }
        LDE listaVeiculosAtt = (LDE) listaVeiculos;
        Noh atual = listaVeiculosAtt.getInicio();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getProximo();
        }
        txtAreaVeiculos.setText(lista);
    }

    public void listarInicio(ActionEvent event) {
        lista = "";
        txtAreaVeiculos.setStyle("-fx-text-fill: BLACK");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaVeiculos.estahVazia()) {
            txtAreaVeiculos.setText("A lista está vazia.");
            return;
        }
        LDE listaVeiculosAtt = (LDE) listaVeiculos;
        Noh atual = listaVeiculosAtt.getInicio();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getProximo();
        }
        txtAreaVeiculos.setText(lista);
    }

    public void listarFinal(ActionEvent event) {
        lista = "";
        txtAreaVeiculos.setStyle("-fx-text-fill: BLACK");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaVeiculos.estahVazia()) {
            txtAreaVeiculos.setText("A lista está vazia.");
            return;
        }
        LDE listaVeiculosAtt = (LDE) listaVeiculos;
        Noh atual = listaVeiculosAtt.getFim();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getAnterior();
        }
        txtAreaVeiculos.setText(lista);
    }

    @FXML
    void voltarMenuVeiculo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PampaLoca/FXML/MenuVeiculos.fxml"));
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}