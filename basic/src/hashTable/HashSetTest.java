package hashTable;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer, Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.printAll();

        hashSet.remove(2);
        hashSet.remove(4);
        boolean contain = hashSet.isContain(2);
        System.out.println("contain 2 = " + contain);
        hashSet.printAll();

        hashSet.clear();
        boolean empty = hashSet.isEmpty();
        System.out.println("empty = " + empty);
    }
}
