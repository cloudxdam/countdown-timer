package dp.dev.countdowntimer.model;

/**
 * Represents the state and configuration of a countdown timer.
 *
 * <p>The model is independent of the JavaFX user interface and is
 * responsible only for storing the timer's data and state.</p>
 */
public class TimerModel {

    private int durationSeconds;
    private int remainingSeconds;
    private TimeState state;

    /**
     * Creates a new countdown timer with the specified duration.
     *
     * @param durationSeconds the initial duration in seconds
     */
    public TimerModel(int durationSeconds)  {
        this.durationSeconds = durationSeconds;
        this.remainingSeconds = durationSeconds;
    }

    /* Getters & Setters */
    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }

    public TimeState getState() {
        return state;
    }

    public void setState(TimeState state) {
        this.state = state;
    }

    /**
     * Decreases the remaining time by one second without going below zero.
     */
    public void decrementSecond() {
        if (remainingSeconds > 0) {
            remainingSeconds--;

            if (remainingSeconds == 0) {
                state = TimeState.STOPPED;
            }
        }
    }

    /* Changing state methods */
    public void start() {
        state = TimeState.RUNNING;
    }

    public void pause() {
        state = TimeState.PAUSED;
    }

    public void reset() {
        remainingSeconds = durationSeconds;
        state = TimeState.STOPPED;
    }

    /**
     * Returns whether the countdown has reached zero.
     *
     * @return true if no time remains, otherwise false
     */
    public boolean isFinished() {
        return remainingSeconds == 0;
    }
}
