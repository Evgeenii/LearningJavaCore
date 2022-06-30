package lesson7.expert.Task2;

public class Car implements CarService {
    private int coast;

    public Car(int coast) {
        this.coast = coast;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    @Override
    public String printCoast() throws CoastException {
        if (coast <= 0) {
            throw new CoastException("Неизвестна мне", coast);
        } else {
            return "Стоимость" + coast;
        }
    }
}

