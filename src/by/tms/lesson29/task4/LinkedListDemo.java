package by.tms.lesson29.task4;

public class LinkedListDemo {

    class Node {
        Object obj;
        Node previous;
        Node next;

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Object obj, Node previous, Node next) {
            this.obj = obj;
            this.previous = previous;
            this.next = next;
        }

        public Node() {
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean add(Object object) {
        Node n = new Node();
        if (first == null) {
            n.setPrevious(null);
            n.setObj(object);
            n.setNext(null);
            first = n;
            last = n;
        } else {
            n.setPrevious(last);
            n.setObj(object);
            n.setNext(null);
            last.setNext(n);
            last = n;
        }
        size++;
        return true;
    }

    public boolean remove(int index) {
        Node temp = node(index);
        if (temp == first || temp == last) {
            if (temp == first) {
                temp.next.previous = null;
                first = temp.next;
            } else if (temp == last) {
                temp.previous.next = null;
                last = temp.previous;
            }

        } else {
            temp.next.previous = temp.previous;
            temp.previous.next = temp.next;
        }
        size--;
        return true;
    }

    public Object get(int index) {
        if (index >= 0 || index <= size) {
            Node temp = node(index);
            return temp.obj;
        }
        return "Неверно введенный диапазон.";
    }

    public Node node(int index) {
        Node temp = null;
        if (first != null) {
            temp = first;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }
}
