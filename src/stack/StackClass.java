package stack;

import java.util.Iterator;

public class StackClass<T> implements Iterable<T> {
    private Object[] array;
    private int top;

    public StackClass(int capacity) {
        array = new Object[capacity];
        top = -1;
    }

    public void push(T item) {
        if (top == array.length - 1) {
            throw new IllegalStateException("Стек переполнен!");
        }

        array[++top] = item;
    }

    public T pop() {
        if (top == -1) {
            throw new IllegalStateException("Стек пуст!");
        }

        @SuppressWarnings("unchecked")
        T result = (T) array[top];
        array[top--] = null; // Освободим ссылку на объект после извлечения

        return result;
    }

    public T peek() {
        if (top == -1) {
            throw new IllegalStateException("Стек пуст!");
        }

        @SuppressWarnings("unchecked")
        T result = (T) array[top];
        return result;
    }

    public int count() {
        return top + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = top;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Нет следующего элемента в стеке!");
                }

                @SuppressWarnings("unchecked")
                T result = (T) array[currentIndex--];
                return result;
            }
        };
    }
}