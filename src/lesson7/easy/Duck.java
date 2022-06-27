package lesson7.easy;

public class Duck implements Flyable {
    private boolean isInjured;

    public Duck(boolean isInjured) {
        this.isInjured = isInjured;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public void fly() throws DuckException {
        if (isInjured) {
            throw new DuckException("утка ранена", true);
        } else {
            System.out.println("утка летит");
        }
    }
}
