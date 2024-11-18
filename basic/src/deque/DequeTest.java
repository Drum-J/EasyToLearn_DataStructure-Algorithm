package deque;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.addFirst(3);
        deque.addLast(4);
        deque.addFirst(2);
        deque.addLast(5);
        deque.addFirst(1);
        deque.printAll();

        System.out.println("first = " + deque.removeFirst());
        System.out.println("last = " + deque.removeLast());
        System.out.println("last = " + deque.removeLast());
        System.out.println("first = " + deque.removeFirst());
        deque.printAll();

        deque.removeFirst();
        System.out.println("isEmpty = " + deque.isEmpty());

        deque.removeFirst(); // 에러 발생
    }
}
