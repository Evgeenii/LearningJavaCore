package lesson7.expert.task2;



public class Main {
    public static void main(String[] args)  {
        String carPrice2 = new CarFactory(new Car(5000)).printPrice();
        System.out.println(carPrice2 + "\n");

        String carPrice = new CarFactory(new Car(-1)).printPrice();
        System.out.println(carPrice);
    }
}
