package stack;

public class Main {
    public static void main(String[] args) {
        StackClass<Integer> stack = new StackClass<>(5);

        System.out.println("Добавление элемента 1 в стек");
        stack.push(1);

        System.out.println("Добавление элемента 5 в стек");
        stack.push(5);

        System.out.println("Добавление элемента 10 в стек");
        stack.push(10);
        System.out.println();

        int count = stack.count();
        System.out.println("Размер стека: " + count);
        System.out.println();

        System.out.println("Количество элеметнов в стеке:");
        for (var items: stack) {
            System.out.println(items);
        }
        System.out.println();

        int topItem = stack.peek();
        System.out.println("Элемент с вершины стека: " + topItem);
        System.out.println();

        int delItem = stack.pop();
        System.out.println("Удаление элемента с вершины стека: " + delItem);
        System.out.println();

        System.out.println("Количество элеметнов в стеке:");
        for (var items: stack) {
            System.out.println(items);
        }
    }
}