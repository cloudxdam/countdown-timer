package dp.dev.countdowntimer.controller;

import dp.dev.countdowntimer.model.TimeState;
import dp.dev.countdowntimer.model.TimerModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.util.Objects;

/**
 * Controls the interaction between the timer view and the timer model.
 *
 * <p>Handles user actions and coordinates the countdown timeline.</p>
 */
public class TimerController {

    private final TimerModel timerModel = new TimerModel(600);
    private Timeline timeline;
    private MediaPlayer alarmPlayer;

    @FXML
    private Label timerLabel;

    @FXML
    private Button actionButton;

    @FXML
    private Spinner<Integer> minutesSpinner;

    @FXML
    private Spinner<Integer> secondsSpinner;

    /**
     * Creates the timer timeline and configures it to execute every second.
     */
    public TimerController() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            timerModel.decrementSecond();

            if (timerModel.isFinished()) {
                timeline.stop();
                alarmPlayer.seek(Duration.ZERO);
                alarmPlayer.play();
            }

            updateTimerLabel();
            updateActionButton();
            updateSpinnerState();
        }
        );
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);

        String soundPath = Objects.requireNonNull(
                TimerController.class.getResource("/sounds/alarm_sound.wav")
        ).toExternalForm();

        Media media = new Media(soundPath);
        alarmPlayer = new MediaPlayer(media);
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

    /**
     * Initializes the timer view with the current remaining time.
     */
    @FXML
    private void initialize() {
        int duration = timerModel.getDurationSeconds();

        minutesSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, duration / 60));

        secondsSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, duration % 60));

        updateTimerLabel();
        updateActionButton();
        updateSpinnerState();
    }

    /**
     * Starts, resumes or pauses the countdown depending on its current state.
     */
    @FXML
    private void handleAction() {
        if (timerModel.getState() == TimeState.RUNNING) {
            timerModel.pause();
            timeline.pause();
        } else if (timerModel.getState() == TimeState.PAUSED) {
            timerModel.start();
            timeline.play();
        } else {
            updateTimerDuration();
            if (!timerModel.isFinished()) {
                timerModel.start();
                timeline.play();
            }
        }
        updateActionButton();
        updateSpinnerState();
    }

    /**
     * Updates the action button text according to the current timer state.
     */
    private void updateActionButton() {
        switch (timerModel.getState()) {
            case TimeState.RUNNING -> actionButton.setText("Pause");
            case TimeState.PAUSED -> actionButton.setText("Resume");
            case TimeState.STOPPED -> actionButton.setText("Start");
        }
    }

    @FXML
    private void handleReset() {
        alarmPlayer.stop();
        alarmPlayer.seek(Duration.ZERO);

        updateTimerDuration();
        timerModel.reset();
        timeline.stop();

        updateTimerLabel();
        updateActionButton();
        updateSpinnerState();
    }

    private void updateTimerDuration() {
        int minutes = minutesSpinner.getValue();
        int seconds = secondsSpinner.getValue();

        int totalSeconds = minutes * 60 + seconds;

        timerModel.setDuration(totalSeconds);
    }

    private void updateSpinnerState() {
        boolean enabled = timerModel.getState() == TimeState.STOPPED;

        minutesSpinner.setDisable(!enabled);
        secondsSpinner.setDisable(!enabled);
    }

    /**
     * Releases resources used by the timer controller.
     */
    public void dispose() {
        alarmPlayer.dispose();
    }
}