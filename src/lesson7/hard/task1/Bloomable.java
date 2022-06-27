package lesson7.hard.task1;

public interface Bloomable {
    default void canBloom() {
        System.out.println("умеет цвести");
    }
}
