package tree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(E element) {
        root = insertRecursive(root, element);
    }

    private Node<E> insertRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.leftChild = insertRecursive(current.leftChild, value);
        } else if (value.compareTo(current.value) > 0) {
            current.rightChild = insertRecursive(current.rightChild, value);
        }

        return current;
    }

    @Override
    public boolean contains(E element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node<E> current, E value) {
        if (current == null) {
            return false;
        }
        if (value.equals(current.value)) {
            return true;
        }
        return value.compareTo(current.value) < 0
                ? containsRecursive(current.leftChild, value)
                : containsRecursive(current.rightChild, value);
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> found = searchRecursive(root, element);
        BinarySearchTree<E> resultTree = new BinarySearchTree<>();
        resultTree.root = found;
        return resultTree;
    }

    private Node<E> searchRecursive(Node<E> current, E value) {
        if (current == null || value.equals(current.value)) {
            return current;
        }
        return value.compareTo(current.value) < 0
                ? searchRecursive(current.leftChild, value)
                : searchRecursive(current.rightChild, value);
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        return root != null ? root.leftChild : null;
    }

    @Override
    public Node<E> getRight() {
        return root != null ? root.rightChild : null;
    }

    @Override
    public E getValue() {
        return root != null ? root.value : null;
    }

    public boolean Equal(BinarySearchTree<E> tree1, BinarySearchTree<E> tree2) {
        return EqualRecursive(tree1.getRoot(), tree2.getRoot());
    }

    private boolean EqualRecursive(Node<E> node1, Node<E> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (!node1.value.equals(node2.value)) {
            return false;
        }

        return EqualRecursive(node1.leftChild, node2.leftChild) &&
                EqualRecursive(node1.rightChild, node2.rightChild);
    }
}

