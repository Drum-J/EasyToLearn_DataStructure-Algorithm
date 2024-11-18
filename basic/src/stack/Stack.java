package stack;

import linkedList.LinkedList;

import java.util.EmptyStackException;

public class Stack<T> {
    private final LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void push(T data) {
        this.list.addFirst(data);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어 있습니다.");
        }
        return list.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어 있습니다.");
        }
        return list.getFirst();
    }
}
