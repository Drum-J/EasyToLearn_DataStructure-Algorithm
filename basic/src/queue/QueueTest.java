package queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("isEmpty = " + queue.isEmpty());

        Integer dequeue = queue.dequeue();
        System.out.println("dequeue = " + dequeue);

        Integer peek = queue.peek();
        System.out.println("peek = " + peek);

        queue.dequeue();
        queue.dequeue();

        System.out.println("isEmpty = " + queue.isEmpty());

        queue.peek(); // 에러 발생
    }
}
