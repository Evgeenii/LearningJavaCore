package lesson7.hard.task1;

public class Rose extends Plant implements Bloomable, Smellable {
    @Override
    public void canSmell() {
        System.out.println("роза: умеет пахнуть");
    }

    @Override
    public void canBloom() {
        System.out.println("роза: умеет цвести");
    }
}
