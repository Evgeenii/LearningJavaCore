package lesson7.hard.task1;

public class Pine extends Tree{
    public Pine(boolean hasCones) {
        super(hasCones);
    }

    @Override
    public void canSmell() {
        System.out.println("ель: умеет пахнуть");
    }
}
