package lesson7.easy;

public class Duck implements Flyable {
    private final boolean isInjured;

    public Duck(boolean isInjured) {
        this.isInjured = isInjured;
    }

    public void fly() throws FlyException {
        if (isInjured) {
            throw new FlyException("утка ранена", true);
        } else {
            System.out.println("утка летит");
        }
    }
}
