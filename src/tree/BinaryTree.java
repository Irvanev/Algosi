package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public E getKey() {
        return key;
    }
    @Override
    public void setLeft(AbstractBinaryTree<E> left) {
        this.left = left;
    }
    @Override
    public void setRight(AbstractBinaryTree<E> right) {
        this.right = right;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();
        result.append(" ".repeat(Math.max(0, indent)));
        result.append(getKey()).append("\n");

        if (getLeft() != null) {
            result.append(" ".repeat(Math.max(0, indent))).append("/\n");
            result.append(getLeft().asIndentedPreOrder(indent + 2));
        }

        if (getRight() != null) {
            result.append(" ".repeat(Math.max(0, indent))).append("\\\n");
            result.append(getRight().asIndentedPreOrder(indent + 2));
        }

        return result.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (getLeft() != null) {
            result.addAll(getLeft().preOrder());
        }
        if (getRight() != null) {
            result.addAll(getRight().preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (getLeft() != null) {
            result.addAll(getLeft().inOrder());
        }
        result.add(this);
        if (getRight() != null) {
            result.addAll(getRight().inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (getLeft() != null) {
            result.addAll(getLeft().postOrder());
        }
        if (getRight() != null) {
            result.addAll(getRight().postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (getLeft() != null) {
            getLeft().forEachInOrder(consumer);
        }
        consumer.accept(getKey());
        if (getRight() != null) {
            getRight().forEachInOrder(consumer);
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
