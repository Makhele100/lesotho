package com.example.lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

import static javafx.beans.binding.Bindings.*;

public class KomevideoController {

    private Media m;
    @FXML
    private MediaView mview;
    private MediaPlayer mplayer;
    private HBox hbox;
    private String Mypath;

    @FXML
    private Button MyFile;

    @FXML
    private Button Audio;

    @FXML
    private Button Video;

    @FXML
    private Slider Timer;

    @FXML
    private Button Backward;

    @FXML
    private Button Back;

    @FXML
    private Button Play;

    @FXML
    private Button Pause;

    @FXML
    private Button Stop;

    @FXML
    private Button Next;

    @FXML
    private Button Forward;

    @FXML
    private Slider Volume;

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

        if (alert.getResult() == ButtonType.OK)
        {
            Stage stage = (Stage) closebtn.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void description(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kome.fxml"));
        Parent root = loader.load();
        Scene currentScene = decriptionbtn.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void pictures(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("komeimages.fxml"));
        Parent root = loader.load();
        Scene currentScene = decriptionbtn.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void videos(ActionEvent event) throws IOException
    {

    }

    @FXML
    void ActionSlowBackward(ActionEvent event)
    {
        mplayer.setRate(0.5);
    }

    @FXML
    void ActionFastForward(ActionEvent event)
    {
        mplayer.setRate(2);
    }

    @FXML
    void ActionNext(ActionEvent event) {

    }

    @FXML
    void ActionBack(ActionEvent event)
    {

    }

    @FXML
    void ActionPause(ActionEvent event)
    {
        mplayer.pause();
    }

    @FXML
    void ActionPlay(ActionEvent event)
    {
        mplayer.play();
        mplayer.setRate(1);
    }

    @FXML
    void ActionStop(ActionEvent event) {
        mplayer.stop();
    }

    @FXML
    void TopFile(ActionEvent event)
    {
        String path =new File("src/1.mp4").getAbsolutePath();
        m = new Media(new File(path).toURI().toString());
        mplayer = new MediaPlayer(m);
        mview.setMediaPlayer(mplayer);
        mplayer.play();
    }

    @FXML
    void ActionVolume(MouseEvent event)
    {
        Volume.setValue(mplayer.getVolume() * 200);
        Volume.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable observable)
            {
                mplayer.setVolume(Volume.getValue() / 200);
            }
        });
    }
}