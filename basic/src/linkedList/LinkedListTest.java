package linkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(0,0);
        linkedList.add(1,1);
        linkedList.add(2,0);
        linkedList.addFirst(2);
        linkedList.addLast(2);

        linkedList.printAll();

        System.out.println("get(1) = " + linkedList.get(1));
        System.out.println("get(3) = " + linkedList.get(3));

        System.out.println("removeFirst() = " + linkedList.removeFirst());
        System.out.println("removeLast() = " + linkedList.removeLast());

        System.out.println("remove(1) = " + linkedList.remove(1));

        linkedList.printAll();
    }
}
