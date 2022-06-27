package lesson7.hard.task1;

public class Fern extends Plant implements Bloomable {
    @Override
    public void canBloom() {
        System.out.println("папоротник: умеет цвести");
    }
}
