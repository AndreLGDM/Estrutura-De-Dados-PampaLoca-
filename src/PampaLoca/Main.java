package PampaLoca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception { //PampaLocaSenha
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PampaLoca/FXML/LoginFuncionario.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        root.setStyle("-fx-background-color: LIGHTBLUE");

        primaryStage.setTitle("PampaLoca");
        primaryStage.setScene(tela);
        primaryStage.show();
    }

}