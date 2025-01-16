package binarytree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();

        //삽입
        searchTree.insert(18);
        searchTree.insert(15);
        searchTree.insert(10);
        searchTree.insert(6);
        searchTree.insert(3);
        searchTree.insert(8);
        searchTree.insert(12);
        searchTree.insert(11);
        searchTree.insert(31);
        searchTree.insert(27);
        searchTree.insert(24);
        searchTree.insert(20);
        searchTree.insert(33);
        searchTree.insert(35);
        searchTree.insert(37);

        searchTree.getRoot().inOrderTraversal(); // 생성한 이진 탐색 트리 중위 순회 -> 정렬된 결과가 나온다.

        //검색
        System.out.println("==== search 6 ====");
        System.out.println(searchTree.search(6));

        System.out.println("==== search 1 ====");
        System.out.println(searchTree.search(1));
    }
}
