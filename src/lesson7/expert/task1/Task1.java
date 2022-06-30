package lesson7.expert.task1;

public class Task1 {
    public static void main(String[] args) {
        Human human = Human.builder()
                .withName("Петр")
                .withAge(20)
                .withWeight(80)
                .build();
        System.out.println(human.info());

    }
}
