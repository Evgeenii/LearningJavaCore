package lesson7.hard.task2;

public class Watch implements Tickable{
    private boolean watchIsBroken;

    public Watch(boolean watchIsBroken) {
        this.watchIsBroken = watchIsBroken;
    }

    public boolean isWatchIsBroken() {
        return watchIsBroken;
    }

    public void setWatchIsBroken(boolean watchIsBroken) {
        this.watchIsBroken = watchIsBroken;
    }


    @Override
    public void tikTak() throws WatchBrokenError {
        if (watchIsBroken) {
            throw new WatchBrokenError("Ошибка: Часы сломались.",true);
        } else {
            System.out.println("Часы тикают");
        }
    }
}
