package by.tms.lesson36.adapter;

public class RiverAdapter implements Lake {

    private River river;

    public RiverAdapter() {
        this.river = new River();
    }

    @Override
    public void swim() {
        river.fastSwimming();
    }
}
