package lesson7.expert.task2;

public class PriceException extends Exception {
    private int price;

    public PriceException(String message, int price) {
        super(message);
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
