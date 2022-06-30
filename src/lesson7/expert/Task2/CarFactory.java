package lesson7.expert.Task2;

public class CarFactory implements CarService {
    private Car car;

    public CarFactory(CarService car) {
        this.car = (Car) car;
    }

    @Override
    public String printCoast() throws CoastException  {
        if (car.getCoast() <= 0) {
            throw new CoastException("Неизвестна мне", car.getCoast());
        } else {
            return "Здравствуй клиент, цена этого авто "
                    + "\n"
                    + car.getCoast()
                    + "\n"
                    + "Хочешь купить авто?";
        }
    }

    public String getCarInfo() {
        try {
            return printCoast();
        } catch (CoastException e) {
            return "Здравствуй клиент, цена этого авто "
                    + "\n"
                    + e.getMessage()
                    + "\n"
                    + "Давайте посмотрим другое авто?";
        }
    }
}
