package cisco;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PhoneDirectory {

    private final int max;
    private final Set<Integer> used;
    private final LinkedList<Integer> released;

    public PhoneDirectory(int max){
        this.max = max;
        used = new HashSet<>();
        released = new LinkedList<>();
    }

    public int get(){
        if(used.size() == max){
            return -1;
        }
        int n = released.isEmpty() ? used.size() : released.remove();
        used.add(n);
        return n;
    }

    public boolean check(int num){
        return !used.contains(num);
    }

    public void release(int num){
        if(used.remove(num)){
            released.add(num);
        }
    }

    public static void main(String[] args) {
        
    }
}
