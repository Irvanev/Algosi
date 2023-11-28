package linkedList;

public class Minions {
    public String name;
    public int age;
    public int eye;
    public Minions prev;
    public Minions next;

    public Minions(String name, int age, int eye) {
        this.name = name;
        this.age = age;
        this.eye = eye;
    }

    public Object[] getData() {
        return new Object[]{name, age, eye};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getEye() {
        return eye;
    }
    public void setEye(int eye) {
        this.eye = eye;
    }

    public Minions getPrev() {
        return prev;
    }

    public void setPrev(Minions prev) {
        this.prev = prev;
    }

    public Minions getNext() {
        return next;
    }

    public void setNext(Minions next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Minions{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", eyes=" + eye +
                '}';
    }
}

// Имена, где  количества гласных по убыванию
// Возраст по возрастанию
// Глаза по убыванию
