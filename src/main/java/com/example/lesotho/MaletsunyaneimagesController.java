package com.example.lesotho;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MaletsunyaneimagesController implements Initializable {

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
    private Button videosbtn;

    @FXML
    private ImageView imageview;

    @FXML
    private Button nextbtn;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private Button prevbtn;


    int count;
    private Node exit;

    @FXML
    void back(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Scene currentScene = imagesbtn.getScene();
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
    void description(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maletsunyane.fxml"));
        Parent root = loader.load();
        Scene currentScene = decriptionbtn.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void pictures(ActionEvent event) {

    }

    @FXML
    void videos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maletsunyanevideo.fxml"));
        Parent root = loader.load();
        Scene currentScene = description.getScene();
        currentScene.setRoot(root);
    }

    /*public void slideshow() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("images/1.png"));
        images.add(new Image("images/2.png"));
        images.add(new Image("images/3.png"));
        images.add(new Image("images/4.png"));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            imageview.setImage(images.get(count));
            count++;
            if (count == images.size()) {
                count = 0;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }*/

    public void translateAnimation(double duration, Node node, double width)
    {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
        translateTransition.setByX(width);
        translateTransition.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        translateAnimation(0.5, pane2, 829);
        translateAnimation(0.5, pane3, 829);
    }

    int show = 0;
    @FXML
    void next(ActionEvent event)
    {
        if(show == 0)
        {
            translateAnimation(0.5, pane2, -829);
            show++;
        }
        else if (show == 1)
        {
            translateAnimation(0.5,pane3, -829);
            show++;
        }
    }

    @FXML
    void prev(ActionEvent event)
    {
        if(show == 1)
        {
            translateAnimation(0.5, pane2, 829);
            show--;
        }
        else if(show == 2)
        {
            translateAnimation(0.5, pane3, 829);
            show--;
        }
    }

}
