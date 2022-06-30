package lesson7.expert.task2;

public class Car implements CarService{
    private final int price;

    public Car(int price) {
        this.price = price;

    }

    @Override
    public int getCarPrice() throws PriceException {
        if (price < 0) {
            throw new PriceException("Неизвестна мне", price);
        } else {
            return price;
        }
    }
}
