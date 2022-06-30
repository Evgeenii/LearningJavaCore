package lesson7.easy;

public class FlyException extends Exception {
    private int countPassengers;
    private boolean isInjured;

    public FlyException(String message, boolean isInjured) {
        super(message);
        this.isInjured = isInjured;
    }

    public FlyException(String message, int countPassengers) {
        super(message);
        this.countPassengers = countPassengers;
    }
}
