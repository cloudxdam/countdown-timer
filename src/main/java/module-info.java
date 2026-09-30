module dp.dev.countdowntimer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens dp.dev.countdowntimer to javafx.fxml;
    exports dp.dev.countdowntimer;
}