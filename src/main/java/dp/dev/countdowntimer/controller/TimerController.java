package dp.dev.countdowntimer.controller;

import dp.dev.countdowntimer.model.TimerModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TimerController {

    private final TimerModel timerModel = new TimerModel(300);
    private final Timeline timeline;

    public TimerController() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            timerModel.decrementSecond();
            updateTimerLabel();
            }
        );
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void updateTimerLabel() {
        int remainingSeconds = timerModel.getRemainingSeconds();

        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        String time = String.format("%02d:%02d", minutes, seconds);

        timerLabel.setText(time);
    }

    @FXML
    private Label timerLabel;

    @FXML
    private void initialize() {
        updateTimerLabel();
    }

    @FXML
    private void handleStart() {
        timerModel.start();
        timeline.play();
    }

    @FXML
    private void handlePause() {
        timerModel.pause();
        timeline.pause();
    }



}