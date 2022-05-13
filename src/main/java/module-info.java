module entrega1.entrega1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens entrega1.controller to javafx.fxml;
    exports entrega1.controller;
    exports entrega1.view;
    opens entrega1.view to javafx.fxml;

}
