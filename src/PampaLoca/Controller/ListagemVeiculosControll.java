package PampaLoca.Controller;

import PampaLoca.LDE;
import PampaLoca.Noh;
import PampaLoca.Veiculo;
import PampaLoca.Arquivo;
import PampaLoca.ILista;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ListagemVeiculosControll {

    @FXML
    private TextArea txtAreaVeiculos;

    String lista = "";

    @FXML
    public void initialize() {

        txtAreaVeiculos.setStyle("-fx-text-fill: #FF69B4;");
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
}