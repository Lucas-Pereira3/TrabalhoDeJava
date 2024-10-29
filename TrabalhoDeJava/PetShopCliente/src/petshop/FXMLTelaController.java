package petshop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FXMLTelaController implements Initializable {
    
    @FXML
    private Button adicionar;

    @FXML
    private Button excluir;

    @FXML
    private Button cancelar;

    @FXML
    private Button salvar;

    @FXML
    private TextField nomeField;  
    @FXML
    private TextField emailField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField rgField;
    @FXML
    private TextField cnpjField;
    @FXML
    private TextField cepField;
    @FXML
    private TextField ruaField;
    @FXML
    private TextField numeroField;
    @FXML
    private TextField telefoneField;
    @FXML
    private TextField celularField;
    @FXML
    private RadioButton homemRadio;
    @FXML
    private RadioButton mulherRadio;

    private String estadoFormulario = "inicial";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarBotoes();
        System.out.println("Inicializando o formulário. Estado: " + estadoFormulario);
    }    
    
    @FXML
    private void handleAdicionar() {
        estadoFormulario = "editando";
        atualizarBotoes();
        System.out.println("Adicionando um novo registro. Estado: " + estadoFormulario);
        // Lógica para preparar o formulário para adição
    }

    @FXML
    private void handleSalvar() {
        // Lógica para salvar os dados
        estadoFormulario = "adicionado";
        atualizarBotoes();
        System.out.println("Registro salvo. Estado: " + estadoFormulario);
    }

    @FXML
    private void handleCancelar() {
        estadoFormulario = "inicial";
        atualizarBotoes();
        System.out.println("Operação cancelada. Estado: " + estadoFormulario);
        // Lógica para reverter alterações, se necessário
    }

    @FXML
    private void handleExcluir() {
        estadoFormulario = "excluindo";
        atualizarBotoes();
        System.out.println("Preparando para excluir o registro. Estado: " + estadoFormulario);
        // Lógica para excluir dados
    }

    private void atualizarBotoes() {
        switch (estadoFormulario) {
            case "inicial":
                adicionar.setDisable(false);
                salvar.setDisable(true);
                cancelar.setDisable(true);
                excluir.setDisable(false);
                break;
            case "editando":
                adicionar.setDisable(true);
                salvar.setDisable(false);
                cancelar.setDisable(false);
                excluir.setDisable(true);
                break;
            case "adicionando":
                adicionar.setDisable(false);
                salvar.setDisable(true);
                cancelar.setDisable(true);
                excluir.setDisable(false);
                break;
            case "excluindo":
                adicionar.setDisable(true);
                salvar.setDisable(true);
                cancelar.setDisable(false);
                excluir.setDisable(true);
                break;
        }
        System.out.println("Botões atualizados. Estado atual: " + estadoFormulario);
    }

}
