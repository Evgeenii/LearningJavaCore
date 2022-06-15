package lesson3.hard;

public class Storage {
    private final String vodkaName;
    private int countBottle;

    public Storage(String vodka, int countBottle) {
        this.vodkaName = vodka;
        this.countBottle = countBottle;
    }

    public String getVodkaName() {
        return vodkaName;
    }

    public void setCountBottle() {
        this.countBottle = countBottle - 1;
    }

    public int getCountBottle() {
        return countBottle;
    }
}
