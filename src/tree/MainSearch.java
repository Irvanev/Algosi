package tree;

import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<Integer> searchTree1 = new BinarySearchTree<>();
        BinarySearchTree<Integer> searchTree2 = new BinarySearchTree<>();

        System.out.println("Введеите колисетво чисел в первом дереве: ");
        int k1 = scanner.nextInt();
        System.out.println("Введите числа, чтобы начать операции: ");

        for (int i = 0; i < k1; i++) {
            int l = scanner.nextInt();
            searchTree1.insert(l);
        }

        System.out.println("Введеите колисетво чисел во втором дереве: ");
        int k2 = scanner.nextInt();
        System.out.println("Введите числа, чтобы начать операции: ");

        for (int i = 0; i < k2; i++) {
            int l = scanner.nextInt();
            searchTree2.insert(l);
        }

        boolean treesEqual = searchTree1.Equal(searchTree1, searchTree2);
        System.out.println("Деревья равны: " + treesEqual);

        System.out.print("Введите число, чтобы проверить его наличие: ");
        int number1 = scanner.nextInt();
        System.out.println("Проврка наличия " + number1 + " в дерееве: " + searchTree1.contains(number1));
        System.out.print("Введите число, чтобы проверить его наличие: ");
        int number2 = scanner.nextInt();
        System.out.println("Проврка наличия " + number2 + " в дерееве: " + searchTree1.contains(number2));

        System.out.print("Введите число, котрое хотите найти: ");
        int n = scanner.nextInt();
        AbstractBinarySearchTree<Integer> searchResult = searchTree1.search(n);
        if (searchResult != null) {
            System.out.println("Найдено число: " + searchResult.getRoot().value);
        } else {
            System.out.println("Элемент не найден.");
        }
        System.out.println("Корень дерева: " + searchTree1.getRoot().value);
    }
}

/*public class MainSearch {
    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();

        searchTree.insert(15);
        searchTree.insert(10);
        searchTree.insert(20);
        searchTree.insert(8);
        searchTree.insert(12);
        searchTree.insert(17);
        searchTree.insert(25);

        System.out.println("Проврка наличия 12 в дерееве: " + searchTree.contains(12));
        System.out.println("Проврка наличия 40 в дерееве: " + searchTree.contains(40));

        AbstractBinarySearchTree<Integer> searchResult = searchTree.search(8);
        if (searchResult != null) {
            System.out.println("Найдено число: " + searchResult.getRoot().value);
        } else {
            System.out.println("Элемент не найден.");
        }
        System.out.println("Корень дерева: " + searchTree.getRoot().value);
    }
}*/
