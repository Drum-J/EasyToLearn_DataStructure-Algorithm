package hashTable;

import linkedList.DoublyLinkedList;
import node.Node;

public class HashSet<K, V> {
    private final HashTable<K, V> hashTable = new HashTable<>();

    public void add(K key) {
        if (this.hashTable.get(key) == null) {
            this.hashTable.set(key, (V) Integer.valueOf(1));
        }
    }

    public boolean isContain(K key) {
        return this.hashTable.get(key) != null;
    }

    public void remove(K key) {
        this.hashTable.remove(key);
    }
    
    public void clear() {
        for (int i = 0; i < this.hashTable.table.length; i++) {
            this.hashTable.table[i].clear();
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = true;

        for (int i = 0; i < this.hashTable.table.length; i++) {
            if (!this.hashTable.table[i].isEmpty()) {
                isEmpty = false;
                break;
            }
        }

        return isEmpty;
    }

    public void printAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hash Set = [");
        for (int i = 0; i < this.hashTable.table.length; i++) {
            Node<HashData<K, V>> currentNode = this.hashTable.table[i].getHead();

            while (currentNode != null) {
                sb.append(currentNode.data.key);
                currentNode = currentNode.next;
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
