package linkedList;

import java.util.Comparator;
import java.util.Iterator;

public class DoublyLinkedList<M> {
    private Minions head;
    private Minions tail;
    private Comparator<Minions> comparer;
    private int count;

    public boolean isEmpty() {
        return count == 0;
    }

    public DoublyLinkedList(Comparator<Minions> comparer) {
        head = null;
        tail = null;
        count = 0;
        this.comparer = comparer;
    }

    public void addLast(Minions minions) {
        Minions newNode = minions;
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            Minions current = tail;
            while (current != null && comparer.compare(newNode, current) < 0) {
                current = current.prev;
            }

            if (current == null) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                newNode.next = current.next;
                newNode.prev = current;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
            }
        }
        count++;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Список пуст.");
        }

        if (count == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        count--;
    }

    public void traverseForward(java.util.function.Consumer<Minions> action) {
        Minions current = head;
        while (current != null) {
            action.accept(current);
            current = current.next;
        }
    }

    public boolean editMinion(Minions oldMinion, Minions newMinion) {
        Minions current = head;
        while (current != null) {
            if (current.name.equals(oldMinion.name)) {
                current.name = newMinion.name;
                current.age = newMinion.age;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public Iterable<Minions> getIteratorForward() {
        return () -> new Iterator<Minions>() {
            private Minions current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Minions next() {
                Minions minion = current;
                current = current.next;
                return minion;
            }
        };
    }

    public Minions get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Индекс находится вне диапазона.");

        Minions current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }
}