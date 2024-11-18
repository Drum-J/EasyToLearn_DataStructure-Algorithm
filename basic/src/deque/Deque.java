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
        if (isEmpty()) {
            throw new IllegalStateException("Deque 가 비어 있습니다.");
        }

        return this.list.removeFirst();
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque 가 비어 있습니다.");
        }

        return this.list.removeLast();
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque 가 비어 있습니다.");
        }

        return this.list.getFirst();
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque 가 비어 있습니다.");
        }

        return this.list.getLast();
    }

    public void printAll() {
        this.list.printAll();
    }
}
