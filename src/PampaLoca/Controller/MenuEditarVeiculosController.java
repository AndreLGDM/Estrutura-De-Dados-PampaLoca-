package PampaLoca.Controller;

import java.io.IOException;

import PampaLoca.*;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuEditarVeiculosController {

    @FXML
    private Label lugaresModificado;

    @FXML
    private Label anoInvalido;

    @FXML
    private Label anoModificado;

    @FXML
    private Text anoNovo;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Button buttonEditarVeiculo;

    @FXML
    private MenuButton buttonEscolha;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonSalvar2;

    @FXML
    private Button buttonSalvar3;

    @FXML
    private Button buttonSalvar4;

    @FXML
    private Button buttonSalvar5;

    @FXML
    private Button buttonSalvar6;

    @FXML
    private Button buttonSalvar7;

    @FXML
    private Label categoriaInexistente;

    @FXML
    private Label categoriaInvalida;

    @FXML
    private Label categoriaModificada;

    @FXML
    private Text categoriaNova;

    @FXML
    private Text digitePlaca;

    @FXML
    private MenuItem editarAno;

    @FXML
    private MenuItem editarCategoria;

    @FXML
    private MenuItem editarLugares;

    @FXML
    private MenuItem editarMarca;

    @FXML
    private MenuItem editarModelo;

    @FXML
    private MenuItem editarPlaca;

    @FXML
    private MenuItem editarPotencia;

    @FXML
    private Label lugaresInvalido;

    @FXML
    private Text lugaresNovo;

    @FXML
    private Label marcaModificada;

    @FXML
    private Text marcaNova;

    @FXML
    private Label modeloModificado;

    @FXML
    private Text modeloNovo;

    @FXML
    private Label placaInvalida;

    @FXML
    private Label placaModificada;

    @FXML
    private Text placaNova;

    @FXML
    private Label potenciaInvalida;

    @FXML
    private Label potenciaModificada;

    @FXML
    private Text potenciaNova;

    @FXML
    private TextField txtAnoNovo;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBusca;

    @FXML
    private TextField txtCategoriaNova;

    @FXML
    private TextField txtLugaresNovo;

    @FXML
    private TextField txtMarcaNova;

    @FXML
    private TextField txtModeloNovo;

    @FXML
    private TextField txtPlacaNova;

    @FXML
    private TextField txtPotenciaNova;

    @FXML
    private Text veiculo;

    @FXML
    private Label veiculoInexistente;

    @FXML
    private Button voltar;

    @FXML
    void initialize() {
        veiculoInexistente.setVisible(false);
        categoriaInexistente.setVisible(false);
        placaInvalida.setVisible(false);
        anoInvalido.setVisible(false);
        potenciaInvalida.setVisible(false);
        lugaresInvalido.setVisible(false);
        categoriaInvalida.setVisible(false);
        potenciaInvalida.setVisible(false);
        categoriaInvalida.setVisible(false);
        buttonEditarVeiculo.setVisible(false);
        buttonEscolha.setVisible(false);
        buttonSalvar.setVisible(false);
        buttonSalvar2.setVisible(false);
        buttonSalvar3.setVisible(false);
        buttonSalvar4.setVisible(false);
        buttonSalvar5.setVisible(false);
        buttonSalvar6.setVisible(false);
        buttonSalvar7.setVisible(false);
        placaNova.setVisible(false);
        modeloNovo.setVisible(false);
        marcaNova.setVisible(false);
        anoNovo.setVisible(false);
        potenciaNova.setVisible(false);
        lugaresNovo.setVisible(false);
        categoriaNova.setVisible(false);
        txtPlacaNova.setVisible(false);
        txtModeloNovo.setVisible(false);
        txtMarcaNova.setVisible(false);
        txtAnoNovo.setVisible(false);
        txtPotenciaNova.setVisible(false);
        txtLugaresNovo.setVisible(false);
        txtCategoriaNova.setVisible(false);
        placaModificada.setVisible(false);
        modeloModificado.setVisible(false);
        marcaModificada.setVisible(false);
        anoModificado.setVisible(false);
        potenciaModificada.setVisible(false);
        lugaresModificado.setVisible(false);
        categoriaModificada.setVisible(false);
    }

    @FXML
    void buscarVeiculo(ActionEvent event) {
        veiculoInexistente.setVisible(false);
        placaInvalida.setVisible(false);

        String busca = txtBusca.getText();

        if (busca.matches("[A-Z]{3}-\\d[A-Z]\\d{2}")) {
            placaInvalida.setVisible(false);
            buttonEditarVeiculo.setVisible(true);
        } else if (busca.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(false);
            buttonEditarVeiculo.setVisible(true);
        } else {
            buttonEditarVeiculo.setVisible(false);
            placaInvalida.setVisible(true);
        }

        if (busca.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || busca.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(false);
            buttonEditarVeiculo.setVisible(true);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh veiculoNoh;
            veiculoNoh = listaVeiculos.busca(busca);
            if (veiculoNoh != null) {
                Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                txtArea.setText(Objeto.toString());
            } else {
                buttonEditarVeiculo.setVisible(false);
                veiculoInexistente.setVisible(true);
            }
        }
    }

    @FXML
    void editaCSV(ActionEvent event) {
        String placaAntiga = txtBusca.getText();
        String placa = txtPlacaNova.getText();
        if (placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || placa.matches("[A-Z]{3}-\\d{4}")) {
            placaInvalida.setVisible(false);
            Arquivo.editarArquivoCSV("lib\\Veiculos.csv", placaAntiga, 0, placaAntiga, 0, placa, 0);
            txtBusca.setText(placa);
            placaNova.setVisible(false);
            buttonSalvar.setVisible(false);
            txtPlacaNova.setVisible(false);
            placaModificada.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                placaModificada.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        } else {
            placaInvalida.setVisible(true);
        }
    }

    @FXML
    void editaCSV2(ActionEvent event) {
        String busca = txtBusca.getText();
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        Noh veiculoNoh = listaVeiculos.busca(busca);
        if (veiculoNoh != null) {
            Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
            String modeloAntigo = Objeto.getModeloVeiculo().toString();
            String modelo = txtModeloNovo.getText();
            Arquivo.editarArquivoCSV("lib\\Veiculos.csv", busca, 0, modeloAntigo, 1, modelo, 1);
            Arquivo.editarArquivoCSV("lib\\Locações.csv", modeloAntigo, 0, modeloAntigo, 0, modelo, 0);
        }
        modeloNovo.setVisible(false);
        buttonSalvar2.setVisible(false);
        txtModeloNovo.setVisible(false);
        modeloModificado.setVisible(true);
        Task<Void> pausaTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(3000);
                return null;
            }
        };
        pausaTask.setOnSucceeded(e -> {
            modeloModificado.setVisible(false);
            buttonEscolha.setVisible(true);
        });
        new Thread(pausaTask).start();
    }

    @FXML
    void editaCSV3(ActionEvent event) {
        String busca = txtBusca.getText();
        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        Noh veiculoNoh = listaVeiculos.busca(busca);
        if (veiculoNoh != null) {
            Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
            String marcaAntiga = Objeto.getMarcaVeiculo().toString();
            String marca = txtMarcaNova.getText();
            Arquivo.editarArquivoCSV("lib\\Veiculos.csv", busca, 0, marcaAntiga, 2, marca, 2);
        }
        marcaNova.setVisible(false);
        buttonSalvar3.setVisible(false);
        txtMarcaNova.setVisible(false);
        marcaModificada.setVisible(true);
        Task<Void> pausaTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(3000);
                return null;
            }
        };
        pausaTask.setOnSucceeded(e -> {
            marcaModificada.setVisible(false);
            buttonEscolha.setVisible(true);
        });
        new Thread(pausaTask).start();
    }

    @FXML
    void editaCSV4(ActionEvent event) {
        String busca = txtBusca.getText();
        String ano = txtAnoNovo.getText();
        if (!ano.matches("[0-9]+")) {
            anoInvalido.setVisible(true);
        } else {
            anoInvalido.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh veiculoNoh = listaVeiculos.busca(busca);
            if (veiculoNoh != null) {
                Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                String anoAntigo = Integer.toString(Objeto.getAnoVeiculo());
                Arquivo.editarArquivoCSV("lib\\Veiculos.csv", busca, 0, anoAntigo, 3, ano, 3);
            }
            anoNovo.setVisible(false);
            buttonSalvar4.setVisible(false);
            txtAnoNovo.setVisible(false);
            anoModificado.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                anoModificado.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        }
    }

    @FXML
    void editaCSV5(ActionEvent event) {
        String busca = txtBusca.getText();
        String potencia = txtPotenciaNova.getText();
        if (!potencia.matches("[0-9]+")) {
            potenciaInvalida.setVisible(true);
        } else {
            potenciaInvalida.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh veiculoNoh = listaVeiculos.busca(busca);
            if (veiculoNoh != null) {
                Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                String potenciaAntiga = Integer.toString(Objeto.getPotenciaVeiculo());
                Arquivo.editarArquivoCSV("lib\\Veiculos.csv", busca, 0, potenciaAntiga, 4, potencia, 4);
            }
            potenciaNova.setVisible(false);
            buttonSalvar5.setVisible(false);
            txtPotenciaNova.setVisible(false);
            potenciaModificada.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                potenciaModificada.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        }
    }

    @FXML
    void editaCSV6(ActionEvent event) {
        String busca = txtBusca.getText();
        String lugares = txtLugaresNovo.getText();
        if (!lugares.matches("[0-9]+")) {
            lugaresInvalido.setVisible(true);
        } else {
            lugaresInvalido.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh veiculoNoh = listaVeiculos.busca(busca);
            if (veiculoNoh != null) {
                Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                String lugaresAntigo = Integer.toString(Objeto.getLugaresVeiculo());
                Arquivo.editarArquivoCSV("lib\\Veiculos.csv", busca, 0, lugaresAntigo, 5, lugares, 5);
            }
            lugaresNovo.setVisible(false);
            buttonSalvar6.setVisible(false);
            txtLugaresNovo.setVisible(false);
            lugaresModificado.setVisible(true);
            Task<Void> pausaTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000);
                    return null;
                }
            };
            pausaTask.setOnSucceeded(e -> {
                lugaresModificado.setVisible(false);
                buttonEscolha.setVisible(true);
            });
            new Thread(pausaTask).start();
        }
    }

    @FXML
    void editaCSV7(ActionEvent event) {
        String busca = txtBusca.getText();
        String categoria = txtCategoriaNova.getText();
        if (!categoria.matches("[0-9]+")) {
            categoriaInvalida.setVisible(true);
        } else {
            categoriaInvalida.setVisible(false);
            ILista listaVeiculos = new LDE();
            ILista listaCategorias = new LDE();
            ILista listaClientes = new LDE();
            ILista listaLocacoes = new LDE();
            Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
            Noh categoriaNoh = listaCategorias.busca(Integer.parseInt(categoria));
            if (categoriaNoh != null) {
                categoriaInexistente.setVisible(false);
                Noh veiculoNoh = listaVeiculos.busca(busca);
                if (veiculoNoh != null) {
                    Veiculo Objeto = (Veiculo) veiculoNoh.getObjeto();
                    String categoriaAntiga = Integer.toString(Objeto.getCategoria().getIdCategoria());
                    Arquivo.editarArquivoCSV("lib\\Veiculos.csv", busca, 0, categoriaAntiga, 6, categoria, 6);
                    categoriaNova.setVisible(false);
                    buttonSalvar7.setVisible(false);
                    txtCategoriaNova.setVisible(false);
                    categoriaModificada.setVisible(true);
                    Task<Void> pausaTask = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            Thread.sleep(3000);
                            return null;
                        }
                    };
                    pausaTask.setOnSucceeded(e -> {
                        categoriaModificada.setVisible(false);
                        buttonEscolha.setVisible(true);
                    });
                    new Thread(pausaTask).start();
                }
            } else {
                categoriaInexistente.setVisible(true);
            }
        }
    }

    @FXML
    void editarAno(ActionEvent event) {
        anoNovo.setVisible(true);
        buttonSalvar4.setVisible(true);
        txtAnoNovo.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarCategoria(ActionEvent event) {
        categoriaNova.setVisible(true);
        buttonSalvar7.setVisible(true);
        txtCategoriaNova.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarLugares(ActionEvent event) {
        lugaresNovo.setVisible(true);
        buttonSalvar6.setVisible(true);
        txtLugaresNovo.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarMarca(ActionEvent event) {
        marcaNova.setVisible(true);
        buttonEscolha.setVisible(false);
        buttonSalvar3.setVisible(true);
        txtMarcaNova.setVisible(true);
    }

    @FXML
    void editarModelo(ActionEvent event) {
        modeloNovo.setVisible(true);
        buttonSalvar2.setVisible(true);
        txtModeloNovo.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarPlaca(ActionEvent event) {
        placaNova.setVisible(true);
        buttonEscolha.setVisible(false);
        buttonSalvar.setVisible(true);
        txtPlacaNova.setVisible(true);
    }

    @FXML
    void editarPotencia(ActionEvent event) {
        potenciaNova.setVisible(true);
        buttonSalvar5.setVisible(true);
        txtPotenciaNova.setVisible(true);
        buttonEscolha.setVisible(false);
    }

    @FXML
    void editarVeiculo(ActionEvent event) {
        buttonEscolha.setVisible(true);
        digitePlaca.setVisible(false);
        veiculo.setVisible(false);
        buttonEditarVeiculo.setVisible(false);
        buttonBuscar.setVisible(false);
        txtArea.setVisible(false);
        txtBusca.setVisible(false);
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
