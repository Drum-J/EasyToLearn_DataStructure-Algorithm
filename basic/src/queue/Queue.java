package queue;

import linkedList.LinkedList;

public class Queue<T> {

    // Queue 자체는 단방향 LinkedList 만으로도 충분히 구현이 가능하다.
    private final LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void enqueue(T data) {
        this.list.addLast(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어 있습니다.");
        }

        return this.list.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어 있습니다.");
        }

        return this.list.getFirst();
    }
}
