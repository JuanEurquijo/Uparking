package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IAdminDAO;
import entrega2.co.uparking.solid.clean.entidades.entities.Administrator;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.AdminDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignInAdminController {

    @FXML
    public TextField txtUser;
    public PasswordField txtPassw;
    public Button btnEnter;
    public Button btnClean;

    List<Administrator> cuentas = new ArrayList<>();

    IAdminDAO model = new AdminDAO();

    private boolean encontrada;
    @FXML
    public void SignIn(ActionEvent actionEvent) throws IOException {


        if (btnEnter.equals(actionEvent.getSource())) {

            if (!txtUser.getText().isEmpty() && !txtPassw.getText().isEmpty()) {

                cuentas = model.checkAccounts();

                if (cuentas != null) {

                    for (Administrator c : cuentas) {
                        if (c.getNameUser().equals(txtUser.getText()) && c.getPassword().equals(txtPassw.getText())) {
                            encontrada = true;
                            cleanFields();
                            break;
                        }
                    }

                    if (encontrada) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("¡BIENVENIDO!");
                        alert.showAndWait();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/RegisterValet.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                        encontrada = false;

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("ERROR");
                        alert.setContentText("¡Usuario o contraseña incorrectos!");
                        alert.showAndWait();
                        cleanFields();
                    }
                }
            }
        }else{
            cleanFields();
        }

    }
    @FXML
    public void Clean(ActionEvent actionEvent) {
         cleanFields();
    }

    public void cleanFields(){
        txtUser.setText("");
        txtPassw.setText("");
    }
}
