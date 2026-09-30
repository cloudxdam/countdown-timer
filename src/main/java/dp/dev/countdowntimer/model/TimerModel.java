package dp.dev.countdowntimer.model;

/**
 * Represents the state and configuration of a countdown timer.
 *
 * <p>The model is independent of the JavaFX user interface and is
 * responsible only for storing the timer's data and state.</p>
 */
public class TimerModel {

    private int durationSeconds;
    private int remainingTime;
    private TimeState state;

    /**
     * Creates a new countdown timer with the specified duration.
     *
     * @param durationSeconds the initial duration in seconds
     */
    public TimerModel(int durationSeconds)  {
        this.durationSeconds = durationSeconds;
        this.remainingTime = durationSeconds;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public TimeState getState() {
        return state;
    }

    public void setState(TimeState state) {
        this.state = state;
    }
}
