package lesson3.easy;

public class Cat {

    private String name;
    public boolean isAStrayCat;

    public Cat(String name, boolean isAStrayCat) {
        this.setName(name);
        this.isAStrayCat = isAStrayCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAStrayCat() {
        return isAStrayCat;
    }

    public void setAStrayCat(boolean AStrayCat) {
        isAStrayCat = AStrayCat;
    }

}
