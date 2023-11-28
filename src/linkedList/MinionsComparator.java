package linkedList;

import java.util.Comparator;

public class MinionsComparator implements Comparator<Minions> {
@Override
    public int compare(Minions x, Minions y) {

    if (x.eye != y.eye) {
        return y.eye - x.eye;
    } else if (x.age != y.age) {
        return y.age - x.age;
    } else {
        int vowelCountX = countVowels(x.getName());
        int vowelCountY = countVowels(y.getName());
        return Integer.compare(vowelCountY, vowelCountX);
    }
}

    private int countVowels(String str) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
