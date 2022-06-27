package lesson7.hard.task1;

public abstract class Tree implements Smellable {
    boolean hasCones = true;

    public Tree(boolean hasCones) {
        this.hasCones = hasCones;
    }

    public boolean isHasCones() {
        return hasCones;
    }

    public void setHasCones(boolean hasCones) {
        this.hasCones = hasCones;
    }

}
