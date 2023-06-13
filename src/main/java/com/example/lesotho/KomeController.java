package com.example.lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
//import javafx.scene.media.MediaView;

public class KomeController
{

    @FXML
    private Button backbtn;

    @FXML
    private Button closebtn;

    @FXML
    private Button decriptionbtn;

    @FXML
    private AnchorPane description;

    @FXML
    private Button imagesbtn;

    @FXML
    private AnchorPane pictures;

    //@FXML
    //private MediaView videos;

    @FXML
    private Button videosbtn;

    @FXML
    void back(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Scene currentScene = backbtn.getScene();
        currentScene.setRoot(root);
    }


    @FXML
    void close(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close confirmation");
        alert.setContentText("Are you sure you want to Close?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            Stage stage = (Stage) closebtn.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void description(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kome.fxml"));
        Parent root = loader.load();
        Scene currentScene = pictures.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void pictures(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("komeimages.fxml"));
        Parent root = loader.load();
        Scene currentScene = description.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void videos(ActionEvent event) {

    }

}
