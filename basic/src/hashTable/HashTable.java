package hashTable;

import linkedList.DoublyLinkedList;
import node.Node;

public class HashTable<K, V> {
    DoublyLinkedList<HashData<K, V>>[] table;

    public HashTable() {
        this.table = new DoublyLinkedList[10];
        for (int i = 0; i < 10; i++) {
            table[i] = new DoublyLinkedList<>();
        }
    }

    // key 값은 항상 숫자가 온다는 가정
    public int hash(K key) {
        return (Integer) key % 10;
    }

    public void set(K key, V value) {
        this.table[this.hash(key)].addFirst(new HashData<>(key, value));
    }

    public V get(K key) {
        Node<HashData<K, V>> currentNode = this.table[this.hash(key)].getHead();

        while (currentNode != null) {
            if (currentNode.data.key.equals(key)) {
                return currentNode.data.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    public V remove(K key) {
        DoublyLinkedList<HashData<K, V>> list = this.table[this.hash(key)];
        Node<HashData<K, V>> currentNode = list.getHead();

        int deletedIndex = 0;

        while (currentNode != null) {
            if (currentNode.data.key.equals(key)) {
                return list.remove(deletedIndex).value;
            }
            currentNode = currentNode.next;
            deletedIndex++;
        }

        return null;
    }
}
