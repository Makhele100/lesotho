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
import java.util.Optional;

import static javafx.beans.binding.Bindings.*;

public class KatsevideoController {

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
    private Button comment;

    @FXML
    private MediaView mediaview;

    @FXML
    private Button pause;

    @FXML
    private Button play;

    @FXML
    private Button replay;

    private MediaPlayer mediaPlayer;


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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("katse.fxml"));
        Parent root = loader.load();
        Scene currentScene = decriptionbtn.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void pictures(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("katseimages.fxml"));
        Parent root = loader.load();
        Scene currentScene = decriptionbtn.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    void videos(ActionEvent event) throws IOException
    {

    }

    @FXML
    void ratecomment(ActionEvent event)
    {
        TextInputDialog textInput = new TextInputDialog();
        textInput.setTitle("Please Leave a Comment");
        textInput.getDialogPane().setContentText("Review:");
        Optional<String> results = textInput.showAndWait();
        TextField input = textInput.getEditor();

        if(input.getText() != null && input.getText().toString().length() != 0)
        {
            System.out.println("Your Review: "+ input.getText().toString().length());
        }
        else
        {
            System.out.println("No Review Entered");
        }
    }


        @FXML
        void ActionFastForward(ActionEvent event)
        {
            Duration currentTime = mediaPlayer.getCurrentTime();
            Duration targetTime = currentTime.add(Duration.seconds(5));
            mediaPlayer.seek(targetTime);
        }

        @FXML
        void pausevideo(ActionEvent event) {
            // Pause the video
            if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
            }
        }

        @FXML
        void playbackvideo(ActionEvent event) {
            // Perform video playback
            if (mediaPlayer != null) {
                mediaPlayer.setRate(1.0); // Set playback rate to normal speed
            }
        }

        @FXML
        void playvideo(ActionEvent event)
        {
            String path =new File("src/1.mp4").getAbsolutePath();
            m = new Media(new File(path).toURI().toString());
            mplayer = new MediaPlayer(m);
            mview.setMediaPlayer(mplayer);
            mplayer.play();

            if (mediaPlayer != null && mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
                mediaPlayer.play();
            }
        }

        @FXML
        void replayvideo(ActionEvent event) {
            // Replay the video from the beginning
            if (mediaPlayer != null) {
                mediaPlayer.seek(Duration.ZERO);
                mediaPlayer.play();
            }
        }

        public void setMediaPlayer(MediaPlayer mediaPlayer) {
            this.mediaPlayer = mediaPlayer;
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