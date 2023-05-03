package PampaLoca.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MenuExcluirVeiculoController {

    @FXML
    private Text Veiculo;

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
    private Text digitePlaca;

    @FXML
    private Label excluirNao;

    @FXML
    private Label excluirSim;

    @FXML
    private Label placaInvalida;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBusca;

    @FXML
    private Label veiculoInexistente;

    @FXML
    private Label veiculoLocado;

    @FXML
    private Button voltar;

    @FXML
    public void initialize() {
        buttonEscolha.setVisible(false);
        buttonExcluir.setVisible(false);
        veiculoInexistente.setVisible(false);
        placaInvalida.setVisible(false);
        excluirNao.setVisible(false);
        excluirSim.setVisible(false);
        veiculoLocado.setVisible(false);
    }

    @FXML
    void buscarVeiculo(ActionEvent event) {

    }

    @FXML
    void confirmarExcluir(ActionEvent event) {

    }

    @FXML
    void excluirVeiculo(ActionEvent event) {

    }

    @FXML
    void negarExcluir(ActionEvent event) {

    }

    @FXML
    void voltarMenuVeiculos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FMXL/MenuVeiculos.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

}

