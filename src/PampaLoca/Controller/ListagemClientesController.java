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

public class ListagemClientesController {

    @FXML
    private TextArea txtAreaClientes;

    @FXML
    private Button buttonOK;

    @FXML
    private Button buttonInicio;

    @FXML
    private Button buttonFim;

    String lista = "";

    @FXML
    public void initialize() {
        txtAreaClientes.setStyle("-fx-text-fill: BLACK");
        String linhaTracejada = "";
        for (int i = 0; i < 132; i++) {
            linhaTracejada += "-";
        }
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

        if (listaClientes.estahVazia()) {
            txtAreaClientes.setText("A lista está vazia.");
            return;
        }
        LDE listaClientesAtt = (LDE) listaClientes;
        Noh atual = listaClientesAtt.getInicio();
        while (atual != null) {
            lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
            atual = atual.getProximo();
        }
        txtAreaClientes.setText(lista);
    }

    public void listarInicio(ActionEvent event) {
    String lista = "";
    txtAreaClientes.setStyle("-fx-text-fill: BLACK");
    String linhaTracejada = "";
    for (int i = 0; i < 132; i++) {
        linhaTracejada += "-";
    }
    ILista listaVeiculos = new LDE();
    ILista listaCategorias = new LDE();
    ILista listaClientes = new LDE();
    ILista listaLocacoes = new LDE();
    Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

    if (listaClientes.estahVazia()) {
        txtAreaClientes.setText("A lista está vazia.");
        return;
    }
    LDE listaClientesAtt = (LDE) listaClientes;
    Noh atual = listaClientesAtt.getInicio();
    while (atual != null) {
        lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
        atual = atual.getProximo();
    }
    txtAreaClientes.setText(lista);
    }

    public void listarFinal(ActionEvent event) {
        String lista = "";
            txtAreaClientes.setStyle("-fx-text-fill: BLACK");
            String linhaTracejada = "";
            for (int i = 0; i < 132; i++) {
                linhaTracejada += "-";
            }
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);

            if (listaClientes.estahVazia()) {
                txtAreaClientes.setText("A lista está vazia.");
                return;
            }
            LDE listaClientesAtt = (LDE) listaClientes;
            Noh atual = listaClientesAtt.getFim();
            while (atual != null) {
                lista += atual.getObjeto().toString() + "\n" + linhaTracejada +"\n";
                atual = atual.getAnterior();
            }
            txtAreaClientes.setText(lista);
    }

    @FXML
    void voltarMenuVeiculo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PampaLoca/FMXL/MenuClientes.fxml"));
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }
}