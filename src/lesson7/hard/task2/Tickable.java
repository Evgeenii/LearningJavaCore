package lesson7.hard.task2;

public interface Tickable {
    default void tikTak() throws WatchBrokenError {
        System.out.println("умеют тикать");
    }
}
