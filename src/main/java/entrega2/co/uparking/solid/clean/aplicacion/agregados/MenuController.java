package entrega2.co.uparking.solid.clean.aplicacion.agregados;



import entrega1.controller.InicioSesionController;
import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.entidades.entities.AssignValet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {

    @FXML
    public Button btnRegisterVehicle;
    public Button btnNewService;
    public Button btnAdmin;

    MenuController stage2;
    Cuenta user;


    public void registerVehicle(ActionEvent actionEvent) throws IOException {

        if(btnRegisterVehicle.equals(actionEvent.getSource())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/RegistroVehiculo.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }

    }


    @FXML
    public void createNewService(ActionEvent actionEvent) {

        AssignValet valet = new AssignValet();
        valet.associateValet(this.user);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("¡Se ha asignado un nuevo valet!");
        alert.showAndWait();

    }


    @FXML
    public void EnterAdmin(ActionEvent actionEvent) throws IOException {

        if(btnAdmin.equals(actionEvent.getSource())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/SignInAdmin.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }


    public void receiveparameters(MenuController controller, Cuenta user){
         stage2 = controller;
         this.user = user;
    }
}
