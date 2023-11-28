package linkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Minions> compareMinions = new MinionsComparator();
        DoublyLinkedList<Minions> myMinions = new DoublyLinkedList<Minions>(compareMinions);

        myMinions.addLast(new Minions("Mikle", 43, 5));
        myMinions.addLast(new Minions("Jimbo", 2, 5));
        myMinions.addLast(new Minions("Bob", 35, 5));
        myMinions.addLast(new Minions("Stich", 24,5));
        myMinions.addLast(new Minions("Piterburg", 17, 5));
        myMinions.addLast(new Minions("Pit", 2, 5));
        myMinions.addLast(new Minions("Ledibag", 2, 5));


        System.out.println();
        System.out.println("Миньоны в списке: ");
        for (Minions minions : myMinions.getIteratorForward()) {
            System.out.println("Информация о миньоне: " + Arrays.toString(minions.getData()));
        }

        System.out.println();

        Minions minionWithIndex = myMinions.get(2);
        System.out.println("Миньон под индексом 2: " + Arrays.toString(minionWithIndex.getData()));

        System.out.println();
        System.out.println("Вывод списка в прямом направлении:");
        myMinions.traverseForward(minion -> {
            System.out.println("Имя: " + minion.name + ", Возраст: " + minion.age + ", Количество глаз: " + minion.eye);
        });

        System.out.println();

        Minions oldMinion = new Minions("Stich", 24, 3);
        Minions newMinion = new Minions("Lolo", 39, 4);

        boolean editMinionInfo = myMinions.editMinion(oldMinion, newMinion);

        if (editMinionInfo) {
            System.out.println("Миньон был успешно заменён.");
        } else {
            System.out.println("Миньона не нашли. Где-то потерялся.");
        }
        System.out.println();

        System.out.println("Вывод списка в прямом направлении:");
        myMinions.traverseForward(minion -> {
            System.out.println("Имя: " + minion.name + ", Возраст: " + minion.age + ", Количество глаз: " + minion.eye);
        });

        System.out.println();

        System.out.println("Удаление последнего миньона");
        myMinions.removeLast();
        System.out.println("Удаление выполнено успешно!");

        System.out.println();

        System.out.println("После удаления последнего миньона:");
        myMinions.traverseForward(minion -> System.out.println("Имя: " + minion.name + ", Возраст: " + minion.age + ", Количество глаз: " + minion.eye));
        System.out.println();
    }
}