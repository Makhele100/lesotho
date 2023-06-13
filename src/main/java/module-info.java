module com.example.lesotho {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires javafx.media;


    opens com.example.lesotho to javafx.fxml;
    exports com.example.lesotho;
}