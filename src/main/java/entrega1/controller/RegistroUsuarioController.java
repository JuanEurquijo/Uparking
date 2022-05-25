/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package entrega1.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.CuentasDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author JuanEurquijo
 */
public class RegistroUsuarioController implements Initializable{
    
    @FXML
    private TextField txtNombreUsuario,txtCorreo;
    
    @FXML
    private ComboBox<String> cbTipoDocumento;
    
    @FXML
    private Button btnRegistrar, btnLimpiarReg;
    @FXML
    private VBox panelRegistro;

    @FXML
    private TextField txtNumDocumento;
   
    @FXML
    private CheckBox checkViewPass;
    
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtPasswordMask;
    @FXML
    private PasswordField txtConfirmPassword;
    @FXML
    private TextField txtConfirmPasswordMask;
    
     private ArrayList<Cuenta> cuentas = new ArrayList<>();
     RegistroUsuarioController stage1;
     private boolean aceptado = true;

     private CuentasDAO modelAccount = new CuentasDAO();

 
    public void cleanFields(){
        txtCorreo.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtNombreUsuario.setText("");
        txtNumDocumento.setText("");
        if(cbTipoDocumento.getItems().size()>0){
            cbTipoDocumento.getSelectionModel().select(0);            
        }else{
            cbTipoDocumento.setItems(FXCollections.observableArrayList("Cédula de Ciudadanía","Cédula de Extranjería","Pasaporte"));
            this.cbTipoDocumento.setVisible(true);
        }                
    }
    
   
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cleanFields();
        mostrarContraseña(txtPassword, txtPasswordMask, checkViewPass);
        mostrarContraseña(txtConfirmPassword, txtConfirmPasswordMask, checkViewPass);

    }    

    @FXML
    private void KeyEvent(KeyEvent event) {
         String c = event.getCharacter();
        
        if(c.equalsIgnoreCase(" ")){
            event.consume();
        }
    }

    @FXML
    private void RegisterEvent(ActionEvent event) throws IOException {
        
        Object evt = event.getSource();
        
          if(btnRegistrar.equals(evt)){
        
            if(!txtNombreUsuario.getText().isEmpty() && !txtNumDocumento.getText().isEmpty() && !txtCorreo.getText().isEmpty() &&
               !txtConfirmPassword.getText().isEmpty() && !txtPassword.getText().isEmpty()){
                
                if(validateEmail(txtCorreo.getText())){
                    
                    if(txtNombreUsuario.getText().length()>=3){

                            if(txtConfirmPassword.getText().equals(txtPassword.getText())){

                                Cuenta account = new Cuenta();
                                account.setEmail(txtCorreo.getText());
                                account.setPassword(txtPassword.getText());
                                account.setUser(txtNombreUsuario.getText());
                                account.setTipoDoc(cbTipoDocumento.getSelectionModel().getSelectedItem());
                                try{
                                account.setDocument(Integer.valueOf(txtNumDocumento.getText()));
                                aceptado = true;
                                }catch(NumberFormatException e){
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
                                    alert.setContentText("El número de documento no es válido");
                                    alert.showAndWait();
                                    aceptado = false;
                                  
                                }
                                
                               
                                cuentas.add(account);
                                
                                if(modelAccount.insertAccount(account) && InsertarCuenta(cuentas) && aceptado == true){
                                    
                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setHeaderText(null);
                                    alert.setTitle("OPERACIÓN ÉXITOSA");
                                    alert.setContentText("El Usuario ha sido registrado de manera éxitosa");
                                    alert.showAndWait();
                                  
                                    cleanFields();


                                }else{

                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
                                    alert.setContentText("No se pudo agregar el usuario!");
                                    alert.showAndWait();

                                }

                            }else{
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
                                    alert.setContentText("Las contraseñas no coinciden, por favor verifique e intente nuevamente");
                                    alert.showAndWait();

                            }
                        
                      }else{
                       
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
                                    alert.setContentText("El Nombre de usuario debe contener al menos TRES caracteres");
                                    alert.showAndWait();           
                    }
                    
                }else{
                    
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
                                    alert.setContentText("El Email que ha ingresado no es valido");
                                    alert.showAndWait();  
                    
                }
                                
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debe llenar todos los campos obligatorios");
                alert.showAndWait(); 
               
            }      
             

                                
        }else if(btnLimpiarReg.equals(evt)){        
            cleanFields();      
        }
          
        
        
   
    }





    @FXML
    private void CleanEvent(ActionEvent event) {
        cleanFields();
    }
    
    public static boolean validateEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);                
    }
    
    public boolean InsertarCuenta(ArrayList<Cuenta> cuentas){
        
         boolean insertado = false;
         
           try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("cuentas.txt");

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);
            for(int i = 0; i < cuentas.size(); i++ )
            {
                 escribir.write(cuentas.get(i) + "\n");
            }
           insertado = true;
            escribir.close();
        } catch (IOException e) {
            System.out.println("No se puedo escribir en el archivo!");
            insertado = false;
        }
        
        
        return insertado;
    }
    
      public void mostrarContraseña(PasswordField pass, TextField text, CheckBox check){
    
        text.setVisible(false);
        text.setManaged(false);
            
        text.managedProperty().bind(check.selectedProperty());
        text.visibleProperty().bind(check.selectedProperty());
        
        text.textProperty().bindBidirectional(pass.textProperty());
    
    }
    
    
    
}
