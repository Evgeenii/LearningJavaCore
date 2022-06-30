package lesson7.expert.Task2;


public class Task2 {
    public static void main(String[] args) {

        String factoryRequest = new CarFactory(new Car(5000)).getCarInfo();
        String factoryRequest2 = new CarFactory(new Car(-1)).getCarInfo();

        System.out.println(factoryRequest);
        System.out.println();
        System.out.println(factoryRequest2);
    }
}
