package cisco;

import java.util.Random;

public class ArrayShuffle {

    private int[] a,o;

    private Random random = new Random();

    private ArrayShuffle(int[] a){
        this.a = a;
        o = a.clone();
    }

    private int[] reset(){
        a = o;
        o = o.clone();
        return a;
    }

    public int[] shuffle(){
        return a;
    }

    public static void main(String[] args) {

    }
}
