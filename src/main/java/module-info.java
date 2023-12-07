module edu.fiuba.algo3 {
    requires javafx.controls;
    requires java.logging;
    requires javafx.fxml;

    opens edu.fiuba.algo3 to javafx.fxml;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.controlador;
    exports edu.fiuba.algo3.vista;
    opens edu.fiuba.algo3.vista to javafx.fxml;
    opens edu.fiuba.algo3.controlador to javafx.fxml;
}