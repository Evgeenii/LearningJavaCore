package lesson5.hard;

import lesson5.easy.Car;
import lesson5.easy.Lada;
import lesson5.easy.Toyota;

public class CarFactory {

    public static Car newLada() {
        return new Lada();
    }

    public static Car newToyota() {
        return new Toyota();
    }
}
