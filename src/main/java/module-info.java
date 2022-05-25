module entrega1.entrega1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires java.sql;
    requires commons.dbcp2;
    requires java.management;
    requires jasypt;

    opens entrega1.controller to javafx.fxml;
    exports entrega1.controller;
    exports entrega1.view;
    opens entrega1.view to javafx.fxml;

    opens entrega2.co.uparking.solid.clean.aplicacion.agregados to javafx.fxml;
    exports entrega2.co.uparking.solid.clean.aplicacion.agregados;

}
