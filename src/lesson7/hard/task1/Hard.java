package lesson7.hard.task1;

public class Hard {
    public static void main(String[] args) {
        Spruce spruce = new Spruce(true);
        Pine pine = new Pine(true);
        Rose rose = new Rose();
        Fern fern = new Fern();

        Smellable[] smellables = {spruce, pine, rose};
        Bloomable[] bloomables = {rose, fern};

        for (Smellable smellable : smellables) {
            smellable.canSmell();
        }

        for (Bloomable bloomable : bloomables) {
            bloomable.canBloom();
        }
    }
    
<<<<<<< HEAD
    // вопрос про создание множества объектов разными параметрами циклом
=======
    // вопрос про создание множества объектовс разными параметрами циклом 
>>>>>>> 572c74a7992ddf957ad6b14a814ff3a958bb8d81
}
