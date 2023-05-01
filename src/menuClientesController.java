import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class menuClientesController implements Initializable{

    @FXML
    private Button addButton;

    @FXML
    private TextField cnhField;

    @FXML
    private TableColumn<Cliente, String> colCNH;

    @FXML
    private TableColumn<Cliente, String> colCPF;

    @FXML
    private TableColumn<Cliente, String> colNome;

    @FXML
    private TableColumn<Cliente, String> colTelefone;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField nomeField;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TextField telField;

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(); // trocar para lde

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) { //dando algum erro
        colNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CPF"));
        colCNH.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CNH"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        tabelaClientes.setItems(listaClientes);

        addButton.setOnMouseClicked((MouseEvent clique) -> {
            if(clique.getClickCount() == 1) {
                addCliente();
            }
        });
    }

    private void addCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(nomeField.getText());
        cliente.setCPF(cpfField.getText());
        cliente.setCNH(cnhField.getText());
        cliente.setTelefone(telField.getText());

        listaClientes.add(cliente);
        tabelaClientes.refresh();
    }
}
