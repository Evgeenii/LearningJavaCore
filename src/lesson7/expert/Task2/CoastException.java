package lesson7.expert.Task2;

public class CoastException extends Exception {
    private int coast;

    public CoastException(String message, int coast) {
        super(message);
        this.coast = coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }
}
