package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.*;
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

public class MenuCadastrarCategoriasController {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Label IdInvalido;

    @FXML
    private TextField txtIdCategoria;

    @FXML
    private TextField txtNomeCategoria;

    @FXML
    private Button voltar;

    @FXML
    public void initialize() {
        IdInvalido.setVisible(false);
    }

    @FXML
    void GerarCategoria(ActionEvent event) throws IOException {
        String ID = txtIdCategoria.getText();
        String Nome = txtNomeCategoria.getText();

        if (!ID.matches("[0-9]+"))
            IdInvalido.setVisible(true);
        else
            IdInvalido.setVisible(false);

        if (ID.matches("[0-9]+")) {
            Categoria categoriaGerada = new Categoria(Integer.parseInt(ID), Nome);
            Arquivo.gravarArquivoCSV(categoriaGerada);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuCategorias.fxml"));
            Parent root = fxmlLoader.load();
            Scene tela = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(tela);
            root.setStyle("-fx-background-color: LIGHTBLUE");
            stage.show();
        }
    }

    @FXML
    void voltarMenuCategorias(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/MenuCategorias.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tela);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        stage.show();
    }

}
