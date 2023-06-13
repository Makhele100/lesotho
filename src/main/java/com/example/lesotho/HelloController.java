package com.example.lesotho;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import static jdk.internal.net.http.common.Utils.close;

public class HelloController
{
    @FXML
    private Hyperlink afriski;

    @FXML
    private Hyperlink bosiu;

    @FXML
    private Button close;

    @FXML
    private Hyperlink katse;

    @FXML
    private Hyperlink kome;

    @FXML
    private Hyperlink maletsunyane;

    @FXML
    private Hyperlink mohale;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void afriskis(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afriski.fxml"));
        Parent root = loader.load();
        Scene currentScene = afriski.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void tbosiu(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bosiu.fxml"));
        Parent root = loader.load();
        Scene currentScene = bosiu.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void closebtn(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close confirmation");
        alert.setContentText("Are you sure you want to Close?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
    }



    @FXML
    void katsed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("katse.fxml"));
        Parent root = loader.load();
        Scene currentScene = katse.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void komec(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kome.fxml"));
        Parent root = loader.load();
        Scene currentScene = kome.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void maletsunyanef(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maletsunyane.fxml"));
        Parent root = loader.load();
        Scene currentScene = maletsunyane.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void mohaled(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mohale.fxml"));
        Parent root = loader.load();
        Scene currentScene = mohale.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void initialize()
    {

    }
}