package dp.dev.countdowntimer.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TimerController {

    @FXML
    private Label timerlabel;

    @FXML
    private void handleStart() {
        System.out.println("Start pressed");
    }

}