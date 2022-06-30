package lesson7.expert.task2;

public class CarFactory implements CarService {

    private final CarService car;

    public CarFactory(CarService car) {
        this.car = car;
    }


    @Override
    public int getCarPrice() throws PriceException {
        return car.getCarPrice();
    }

    public String printPrice() {
        try {
            return "Здравствуй клиент, цена этого авто"
                    + "\n"
                    + car.getCarPrice()
                    + "\n"
                    + "Хочешь купить авто?";

        } catch (PriceException e) {
            return  "Здравствуй клиент, цена этого авто"
                    + "\n"
                    + e.getMessage()
                    + "\n"
                    + "Давайте посмотрим другое авто?";
        }
    }
}
