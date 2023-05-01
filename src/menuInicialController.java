
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class menuInicialController {

    @FXML
    private Button botaoCategorias;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoLocacoes;

    @FXML
    private Button botaoVeiculos;

    @FXML
    protected void abrirMenuCategorias(ActionEvent event) {
        Main.mudarScene("categoria");
    }

    @FXML
    protected void abrirMenuClientes(ActionEvent event) {
        Main.mudarScene("cliente");
    }

    @FXML
    protected void abrirMenuLocacoes(ActionEvent event) {
        Main.mudarScene("locacao");
    }

    @FXML
    protected void abrirMenuVeiculos(ActionEvent event) {
        Main.mudarScene("veiculo");
    }

}
