package lesson7.hard.task2;

public class WatchBrokenError extends Exception {
    private boolean watchIsBroken;


    public WatchBrokenError(String message, boolean watchIsBroken) {
        super(message);
        this.watchIsBroken = watchIsBroken;
    }

    public boolean isWatchIsBroken() {
        return watchIsBroken;
    }
}
