package deque;

import linkedList.DoublyLinkedList;

public class Deque<T> {
    private final DoublyLinkedList<T> list = new DoublyLinkedList<>();

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void addFirst(T data) {
        this.list.addFirst(data);
    }

    public void addLast(T data) {
        this.list.addLast(data);
    }

    public T removeFirst() {
        return this.list.removeFirst();
    }

    public T removeLast() {
        return this.list.removeLast();
    }

    public void printAll() {
        this.list.printAll();
    }
}
