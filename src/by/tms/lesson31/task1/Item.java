package by.tms.lesson31.task1;

public class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
