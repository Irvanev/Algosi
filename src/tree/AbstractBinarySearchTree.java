package tree;

public interface AbstractBinarySearchTree<E extends Comparable<E>> {
    public static class Node<E> {
        public E value;
        public Node<E> leftChild;
        public Node<E> rightChild;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> leftChild, Node<E> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    void insert(E element); // добавляет элемент

    boolean contains(E element); // возвращает true, если дерево содержит данный элемент

    AbstractBinarySearchTree<E> search(E element);
    // возвращает дерево с заданным значением элемента в качестве корневого, если существует, если нет, возвращает пустое дерево

    Node<E> getRoot(); // возвращает корень дерева

    Node<E> getLeft(); // возвращает левое поддерево узла

    Node<E> getRight(); // возвращает правое поддерево узла

    E getValue(); // возвращает значение узла дерева
}
