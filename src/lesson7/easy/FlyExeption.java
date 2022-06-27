package lesson7.easy;

class FlyException extends Exception {
    private int countPassengers;

    public FlyException(String message, int countPassengers) {
        super(message);
        this.countPassengers = countPassengers;
    }


    public int getCountPassengers() {
        return countPassengers;
    }
}
