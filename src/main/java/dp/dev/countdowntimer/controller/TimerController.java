package dp.dev.countdowntimer.controller;

import dp.dev.countdowntimer.model.TimerModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * Controls the interaction between the timer view and the timer model.
 *
 * <p>Handles user actions and coordinates the countdown timeline.</p>
 */
public class TimerController {

    private final TimerModel timerModel = new TimerModel(10);
    private Timeline timeline;

    /**
     * Creates the timer timeline and configures it to execute every second.
     */
    public TimerController() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            timerModel.decrementSecond();

            if (timerModel.isFinished()) {
                timeline.stop();
            }

            updateTimerLabel();
            }
        );
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Updates the timer label with the remaining time in MM:SS format.
     */
    private void updateTimerLabel() {
        int remainingSeconds = timerModel.getRemainingSeconds();

        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        String time = String.format("%02d:%02d", minutes, seconds);

        timerLabel.setText(time);
    }

    @FXML
    private Label timerLabel;

    /**
     * Initializes the timer view with the current remaining time.
     */
    @FXML
    private void initialize() {
        updateTimerLabel();
    }

    @FXML
    private void handleStart() {
        if (!timerModel.isFinished()) {
            timerModel.start();
            timeline.play();
        }
    }

    @FXML
    private void handlePause() {
        timerModel.pause();
        timeline.pause();
    }

    @FXML
    private void handleReset() {
        timerModel.reset();
        timeline.stop();
        updateTimerLabel();
    }

}