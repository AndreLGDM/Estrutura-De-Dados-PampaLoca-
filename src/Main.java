
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
        System.out.println("Hello, World!");
    }

    private static Stage stage;

    private static Scene menuInicial;
    private static Scene menuClientes;
    private static Scene menuVeiculos;
    private static Scene menuCategorias;
    private static Scene menuLocacoes;


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        Parent fxmlInicio = FXMLLoader.load(getClass().getResource("menuInicial.fxml"));
        menuInicial = new Scene(fxmlInicio);

        Parent fxmlCliente = FXMLLoader.load(getClass().getResource("menuClientes.fxml"));
        menuClientes = new Scene(fxmlCliente);

        Parent fxmlVeiculos = FXMLLoader.load(getClass().getResource("menuVeiculos.fxml"));
        menuVeiculos = new Scene(fxmlVeiculos);

        Parent fxmlCategorias = FXMLLoader.load(getClass().getResource("menuCategorias.fxml"));
        menuCategorias = new Scene(fxmlCategorias);

        Parent fxmlLocacoes = FXMLLoader.load(getClass().getResource("menuLocacoes.fxml"));
        menuLocacoes = new Scene(fxmlLocacoes);

        primaryStage.setTitle("Menu Inicial");
        primaryStage.setScene(menuInicial);
        primaryStage.show();
    }

    public static void mudarScene(String scene) {
        switch (scene) {
            case "inicio": stage.setTitle("Menu Inicial"); stage.setScene(menuInicial); break;
            case "cliente": stage.setTitle("Menu Clientes"); stage.setScene(menuClientes); break;
            case "veiculo": stage.setTitle("Menu Veículos"); stage.setScene(menuVeiculos); break;
            case "categoria": stage.setTitle("Menu Categorias"); stage.setScene(menuCategorias); break;
            case "locacao": stage.setTitle("Menu Locações"); stage.setScene(menuLocacoes); break;
        }
    }
}
