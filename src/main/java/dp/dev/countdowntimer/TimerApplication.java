package dp.dev.countdowntimer;

import dp.dev.countdowntimer.controller.TimerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Entry point for the Countdown Timer JavaFX application.
 *
 * <p>Initializes the application window and releases controller resources
 * when the application closes.</p>
 */
public class TimerApplication extends Application {

    /**
     * Initializes the main application window and loads the timer view.
     *
     * @param stage the primary application window
     * @throws IOException if the FXML view cannot be loaded
     */
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