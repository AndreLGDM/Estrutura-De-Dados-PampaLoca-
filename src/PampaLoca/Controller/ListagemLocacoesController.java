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

public class ListagemLocacoesController {

    @FXML
    private TextArea txtAreaLocacoes;

    @FXML
    private Button buttonOK;

    @FXML
    private Button buttonInicio;

    @FXML
    private Button buttonFinal;

    String lista = "";

    @FXML
    public void initialize() {

        txtAreaLocacoes.setStyle("-fx-text-fill: BLACK");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaLocacoes.estahVazia()) {
            txtAreaLocacoes.setText("A lista está vazia.");
            return;
        }
        LDE listaClientesAtt = (LDE) listaLocacoes;
        Noh atual = listaClientesAtt.getInicio();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getProximo();
        }
        txtAreaLocacoes.setText(lista);
    }

    @FXML
    void listarInicio(ActionEvent event){
        lista = "";
        txtAreaLocacoes.setStyle("-fx-text-fill: BLACK");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaLocacoes.estahVazia()) {
            txtAreaLocacoes.setText("A lista está vazia.");
            return;
        }
        LDE listaClientesAtt = (LDE) listaLocacoes;
        Noh atual = listaClientesAtt.getInicio();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getProximo();
        }
        txtAreaLocacoes.setText(lista);
    }

    @FXML
    void listarFinal(ActionEvent event){
        lista = "";
        txtAreaLocacoes.setStyle("-fx-text-fill: BLACK");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaLocacoes.estahVazia()) {
            txtAreaLocacoes.setText("A lista está vazia.");
            return;
        }
        LDE listaClientesAtt = (LDE) listaLocacoes;
        Noh atual = listaClientesAtt.getFim();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getAnterior();
        }
        txtAreaLocacoes.setText(lista);
    }


    @FXML
    void voltarMenuLocacoes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PampaLoca/FMXL/MenuLocacoes.fxml"));
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}