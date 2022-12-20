package by.tms.lesson31.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {

    private List<Item> listItems = new ArrayList<>();

    public Order(List<Item> listItems) {
        this.listItems = listItems;
    }

    public Order() {
    }

    public Integer addItems(Item... items) {
        if (items != null) {
            listItems.addAll(Arrays.asList(items));

            return items.length;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "listItems=" + listItems +
                '}';
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }
}
