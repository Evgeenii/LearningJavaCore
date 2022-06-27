package lesson7.easy;

public class DuckException extends Exception{
    private boolean isInjured;


    public DuckException(String message, boolean isInjured) {
        super(message);
        this.isInjured = isInjured;
    }


    public boolean isInjured() {
        return isInjured;
    }
}
