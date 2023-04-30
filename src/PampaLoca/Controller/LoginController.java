package PampaLoca.Controller;

import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController {

    @FXML
    private RadioButton OcultarSenha;

    @FXML
    private Label SenhaVisivel;

    @FXML
    private Label wrongPassword;

    @FXML
    private Button buttonLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    void efetuarLogin(ActionEvent event) throws IOException {
        String Usuario = txtUser.getText();
        String Senha = txtPassword.getText();

        if (Usuario.equals("PampaLoca") && Senha.equals("PampaLocaSenha")) {
            Parent root = FXMLLoader.load(getClass().getResource("/PampaLoca/FMXL/MenuPrincipal.fxml"));
            Scene tela = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(tela);
            root.setStyle("-fx-background-color: LIGHTBLUE");
            stage.show();

        } else {
            wrongPassword.setVisible(true);
            SenhaVisivel.setVisible(false);
        }
    }

    @FXML
    void mudarVisibilidade(ActionEvent event) {
        if (OcultarSenha.isSelected()) {
            wrongPassword.setVisible(false);
            SenhaVisivel.setVisible(true);
            SenhaVisivel.textProperty().bind(Bindings.concat(txtPassword.getText()));
            OcultarSenha.setText("Ocultar");
        } else {
            SenhaVisivel.setVisible(false);
            OcultarSenha.setText("Mostrar Senha");
        }
    }

    @FXML
    void passwordFildKeyTyped(KeyEvent event) {
        SenhaVisivel.textProperty().bind(Bindings.concat(txtPassword.getText()));
    }

    @FXML
    public void initialize() {
        txtUser.setText("PampaLoca");
        txtUser.setEditable(false);
        SenhaVisivel.setVisible(false);
        wrongPassword.setVisible(false);
    }
}