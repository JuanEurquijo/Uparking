package entrega2.co.uparking.solid.clean.aplicacion.agregados;



import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.entidades.entities.AssignValet;
import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuController {

    @FXML
    public Button btnRegisterVehicle;
    public Button btnNewService;
    public Button btnAdmin;

    MenuController stage2;

    ShowValetController showValet;
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
    public void createNewService(ActionEvent actionEvent) throws IOException {

        ShowValetController showValet = new ShowValetController();
        AssignValet valet = new AssignValet();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/ShowValetAssigned.fxml"));
        Scene scene = new Scene(loader.load());
        ShowValetController controlador = (ShowValetController) loader.getController();
        controlador.showAssignment(showValet, valet.associateValet(this.user));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


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
