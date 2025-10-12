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
        List<E> list = new ArrayList<>(set);
        int count = set.size();
        return count > 0 ? list.get(new Random().nextInt(count)) : null;
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom<Integer> obj = new InsertDeleteGetRandom<>();
        var param_1 = obj.insert(Integer.valueOf(1));
        var param_2 = obj.insert(Integer.valueOf(2));
        var param_3 = obj.remove(Integer.valueOf(3));
        var param_4 = obj.remove(Integer.valueOf(4));
        var param_5 = obj.getRandom() == null ? 0 : (int) obj.getRandom();
        System.out.println(param_1 + "\t" + param_2 + "\t" + param_3 + "\t" + param_4 + "\t" + param_5);
    }
}
