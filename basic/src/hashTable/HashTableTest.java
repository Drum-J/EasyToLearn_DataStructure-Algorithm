package hashTable;

public class HashTableTest {
    public static void main(String[] args) {

        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.set(1,"이운재");
        hashTable.set(4,"최진철");
        hashTable.set(20,"홍명보");
        hashTable.set(6,"유상철");
        hashTable.set(22,"송종국");
        hashTable.set(21,"박지성");
        hashTable.set(5,"김남일");
        hashTable.set(10,"이영표");
        hashTable.set(8,"최태욱");
        hashTable.set(9,"설기현");
        hashTable.set(14,"이천수");

        String get1 = hashTable.get(1);
        System.out.println("get1 = " + get1);

        String remove = hashTable.remove(1);
        System.out.println("remove = " + remove);
        String get11 = hashTable.get(1);
        System.out.println("get11 = " + get11);

        String get21 = hashTable.get(21);
        System.out.println("get21 = " + get21);
    }
}