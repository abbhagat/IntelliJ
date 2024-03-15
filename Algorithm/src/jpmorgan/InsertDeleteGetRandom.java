package jpmorgan;

import java.util.*;

public class InsertDeleteGetRandom<E> {

    private final Set<E> set;

    public InsertDeleteGetRandom() {
        this.set = new HashSet<>();
    }

    private boolean insert(E e) {
        return set.add(e);
    }

    private boolean remove(E e) {
        return set.remove(e);
    }

    private Object getRandom() {
        Random random = new Random();
        List<E> list = new ArrayList<>(set);
        int count = set.size();
        return count > 0 ? list.get(random.nextInt(count)) : 0;
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom<Integer> obj = new InsertDeleteGetRandom<>();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.insert(2);
        boolean param_3 = obj.remove(3);
        boolean param_4 = obj.remove(4);
        int param_5 = (int) obj.getRandom();
        System.out.println(param_1 + "\t" + param_2 + "\t" + param_3 + "\t" + param_4 + "\t" + param_5);
    }
}
