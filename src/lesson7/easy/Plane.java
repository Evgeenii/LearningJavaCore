package lesson7.easy;

public class Plane implements Flyable {
    private int countPassengers;

    public Plane(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public void setCountPassengers(int countPassengers) {

        this.countPassengers = countPassengers;
    }

    public void fly() throws FlyException {
        if (countPassengers < 0) {
            throw new FlyException("пассажиров в самолете меньше 0", countPassengers);
        } else {
            System.out.println("самолёт летит");
        }
    }
}
