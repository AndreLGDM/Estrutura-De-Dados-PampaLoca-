package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.Arquivo;
import PampaLoca.Cliente;
import PampaLoca.ClienteFactory;
import PampaLoca.ILista;
import PampaLoca.LDE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuCadastrarClientesController {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Label cpfInvalido;

    @FXML
    private Label cnhInvalida;

    @FXML
    private Label telefoneInvalido;

    @FXML
    private TextField txtCNH;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    public void initialize() {
        cnhInvalida.setVisible(false);
        cpfInvalido.setVisible(false);
        telefoneInvalido.setVisible(false);
    }

    @FXML
    void GerarCliente(ActionEvent event) throws IOException {
        String Nome = txtNome.getText();
        String CPF = txtCPF.getText();
        String CNH = txtCNH.getText();
        String Telefone = txtTelefone.getText();

        if (!CPF.matches("[0-9]+"))
            cpfInvalido.setVisible(true);
        else
            cpfInvalido.setVisible(false);

        if (!CNH.matches("[0-9]+"))
            cnhInvalida.setVisible(true);
        else
            cnhInvalida.setVisible(false);

        if (!Telefone.matches("[0-9]+"))
            telefoneInvalido.setVisible(true);
        else
            telefoneInvalido.setVisible(false);

        if(CPF.matches("[0-9]+") && CNH.matches("[0-9]+") && Telefone.matches("[0-9]+")){

        Cliente ClienteGerado = ClienteFactory.criarCliente(Nome, CPF, CNH, Telefone);
        ILista listaCliente = new LDE();
        Arquivo.gravarArquivoCSV(ClienteGerado);
        listaCliente.insereFim(ClienteGerado);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuClientes.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
        }
    }

}