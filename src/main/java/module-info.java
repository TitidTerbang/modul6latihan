module com.latihan1.modul6latihan1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.latihan1.modul6latihan1 to javafx.fxml;
    exports com.latihan1.modul6latihan1;
}