package lesson7.hard.task1;

public interface Smellable {
    default void canSmell() {
        System.out.println("умеет пахнуть");
    }
}
