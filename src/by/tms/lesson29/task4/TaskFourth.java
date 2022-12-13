package by.tms.lesson29.task4;

public class TaskFourth {

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        for(int i = 0; i <= 20; i++) {
            list.add("value: " + i);
        }

        for(int i = 0; i <= 20; i++) {
            System.out.println(list.get(i));
        }

        list.remove(16);

        System.out.println(list.get(16));
    }
}
