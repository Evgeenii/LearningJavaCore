package lesson7.hard.task1;

public class Spruce extends Tree{
    public Spruce(boolean hasCones) {
        super(hasCones);
    }

    @Override
    public void canSmell() {
        System.out.println("cосна: умеет пахнуть");
    }
}
