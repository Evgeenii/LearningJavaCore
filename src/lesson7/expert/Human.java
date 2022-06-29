package lesson7.expert;

public class Human {
    private int age;
    private String name;
    private int weight;


    private void setAge(int age) {
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }


    public String info() {
        return name
                + " - возраст "
                + age
                + ", вес "
                + weight;
    }

    public static class HumanBuilder {
        private final Human human;

        public HumanBuilder() {
            this.human = new Human();
        }

        public HumanBuilder withAge(int age) {
            human.setAge(age);
            return this;
        }

        public HumanBuilder withName(String name) {
            human.setName(name);
            return this;
        }

        public HumanBuilder withWeight(int weight) {
            human.setWeight(weight);
            return this;
        }

        public Human build() {
            return human;
        }
    }
}





