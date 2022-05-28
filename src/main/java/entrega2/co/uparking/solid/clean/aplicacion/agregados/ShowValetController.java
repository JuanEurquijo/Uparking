package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ShowValetController {

    public TextField txtTypeDoc;
    public TextField txtNumDoc;
    public TextField txtAge;
    public TextField txtExp;
    public Button btnLeave;
    public TextField txtNameValet;

    ShowValetController stage2;

    ValetParking valet;


    @FXML
    public void leave() {
        Stage stage = (Stage) btnLeave.getScene().getWindow();
        stage.close();
    }

    public void showAssignment(ShowValetController showValet, ValetParking associateValet) {
        this.stage2 = showValet;
        this.valet = associateValet;

        txtNameValet.setText(this.valet.getName());
        txtNameValet.setEditable(false);
        txtTypeDoc.setText(this.valet.getTypeDoc());
        txtTypeDoc.setEditable(false);
        txtNumDoc.setText(String.valueOf(this.valet.getNumDoc()));
        txtNumDoc.setEditable(false);
        txtAge.setText(String.valueOf(this.valet.getAge()));
        txtAge.setEditable(false);
        txtExp.setText(this.valet.getExperience());
        txtExp.setEditable(false);
    }
}
