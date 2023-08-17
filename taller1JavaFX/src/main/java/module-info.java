module ec.edu.espol.taller1javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.taller1javafx to javafx.fxml;
    exports ec.edu.espol.taller1javafx;
}
