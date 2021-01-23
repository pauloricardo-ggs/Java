package cadastro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Cadastro1 {

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtConfEmail;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private PasswordField txtConfSenha;

    @FXML
    void CancelarBt(javafx.event.ActionEvent actionEvent) throws IOException {
        irMenu(actionEvent);
    }

    @FXML
    void CadastrarBt(javafx.event.ActionEvent actionEvent) throws IOException {
        if (CampoVazio()){ irAviso(actionEvent); }
        else { irMenu(actionEvent); }
    }

    boolean CampoVazio(){
        return txtUsuario.getText().equals("") || txtEmail.getText().equals("") || txtConfEmail.getText().equals("") || txtSenha.getText().equals("") || txtConfSenha.getText().equals("");
    }

    void irAviso(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("aviso.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setTitle("Erro");
        stage.setScene(scene);
        stage.show();
    }

    void irMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
}
