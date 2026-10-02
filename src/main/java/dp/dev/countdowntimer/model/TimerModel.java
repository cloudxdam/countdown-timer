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
    private TimeState state = TimeState.STOPPED;

    /**
     * Creates a new countdown timer with the specified duration.
     *
     * @param durationSeconds the initial duration in seconds
     */
    public TimerModel(int durationSeconds)  {
        this.durationSeconds = durationSeconds;
        this.remainingSeconds = durationSeconds;
    }

    /* Getters */
    public int getDurationSeconds() {
        return durationSeconds;
    }


    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public TimeState getState() {
        return state;
    }

    /**
     * Decreases the remaining time by one second without going below zero.
     *
     * <p>The timer automatically changes to {@link TimeState#STOPPED}
     * when the remaining time reaches zero.</p>
     */
    public void decrementSecond() {
        if (remainingSeconds > 0) {
            remainingSeconds--;

            if (remainingSeconds == 0) {
                state = TimeState.STOPPED;
            }
        }
    }

    /**
     * Changes the timer state to {@link TimeState#RUNNING}.
     */
    public void start() {
        state = TimeState.RUNNING;
    }

    /**
     * Changes the timer state to {@link TimeState#PAUSED}.
     */
    public void pause() {
        state = TimeState.PAUSED;
    }

    /**
     * Resets the remaining time to the configured duration
     * and changes the timer state to {@link TimeState#STOPPED}.
     */
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

    /**
     * Configures the timer with a new duration and resets the remaining time.
     *
     * @param durationSeconds the new duration in seconds
     */
    public void setDuration(int durationSeconds) {
        this.durationSeconds = durationSeconds;
        this.remainingSeconds = durationSeconds;
    }
}
