package dp.dev.countdowntimer;

import dp.dev.countdowntimer.model.TimeState;
import dp.dev.countdowntimer.model.TimerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimerModelTest {

    @Test
    void shouldStartTimer() {
        TimerModel timerModel = new TimerModel(600);

        timerModel.start();

        assertEquals(TimeState.RUNNING, timerModel.getState());
    }

    @Test
    void shouldPauseTimer() {
        TimerModel timerModel = new TimerModel(600);

        timerModel.pause();

        assertEquals(TimeState.PAUSED, timerModel.getState());
    }

    @Test
    void shouldResetTimer() {
        TimerModel timerModel = new TimerModel(600);

        timerModel.setDuration(1200);
        timerModel.start();
        timerModel.decrementSecond();

        timerModel.reset();

        assertEquals(1200, timerModel.getRemainingSeconds());
        assertEquals(TimeState.STOPPED, timerModel.getState());
    }

    @Test
    void shouldDecrementRemainingTime() {
        TimerModel timerModel = new TimerModel(600);

        timerModel.decrementSecond();

        assertEquals(599, timerModel.getRemainingSeconds());
    }

    @Test
    void shouldStopWhenReachingZero () {
        TimerModel timerModel = new TimerModel(1);

        timerModel.start();
        timerModel.decrementSecond();

        assertEquals(0, timerModel.getRemainingSeconds());
        assertEquals(TimeState.STOPPED, timerModel.getState());
    }

    @Test
    void shouldSetNewDuration () {
        TimerModel timerModel = new TimerModel(600);

        timerModel.setDuration(300);

        assertEquals(300, timerModel.getDurationSeconds());
        assertEquals(300, timerModel.getRemainingSeconds());
    }

    @Test
    void shouldNotDecrementBelowZero() {
        TimerModel timerModel = new TimerModel(0);

        timerModel.decrementSecond();

        assertEquals(0, timerModel.getRemainingSeconds());
    }
}
