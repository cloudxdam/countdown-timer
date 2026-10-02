package dp.dev.countdowntimer;

import dp.dev.countdowntimer.controller.TimerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TimerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimerApplication.class.getResource("timer-view.fxml"));

        Parent root = fxmlLoader.load();
        TimerController timerController = fxmlLoader.getController();

        Scene scene = new Scene(root, 420, 240);

        stage.setTitle("Countdown Timer");
        stage.setScene(scene);
        stage.setOnHidden(event -> timerController.dispose());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}