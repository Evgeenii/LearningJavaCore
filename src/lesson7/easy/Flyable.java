package lesson7.easy;

public interface Flyable {
    public default void fly() throws FlyException, DuckException {

    }
}
