module com.geekbreins.javafxchat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.geekbreins.javafxchat to javafx.fxml;
    exports com.geekbreins.javafxchat;
}