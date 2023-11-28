package tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(4);
        tree.setLeft(new BinaryTree<>(2));
        tree.setRight(new BinaryTree<>(6));
        tree.getLeft().setLeft(new BinaryTree<>(1));
        tree.getLeft().setRight(new BinaryTree<>(3));
        tree.getRight().setLeft(new BinaryTree<>(5));
        tree.getRight().setRight(new BinaryTree<>(7));

        System.out.println("Indented PreOrder:");
        System.out.println(tree.asIndentedPreOrder(0));

        System.out.println("PreOrder:");
        System.out.println(tree.preOrder());

        System.out.println("InOrder:");
        System.out.println(tree.inOrder());

        System.out.println("PostOrder:");
        System.out.println(tree.postOrder());

        System.out.println("Print InOrder:");
        tree.forEachInOrder(System.out::println);
    }
}

