package javaa.stringjoiner;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner("|");
        joiner.add("Java");
        joiner.add("C++");
        joiner.add("Python");
        joiner.add("Ruby");
        String text = joiner.toString();
        System.out.println(text);
        String CSV = new StringJoiner(",").add("Scala").add("Haskell").add("Lisp").toString();
        System.out.println("CSV: " + CSV);
        text = new StringJoiner(",", "{", "}").add("Car Insurance").add("Health Insurance").add("Life Insurance").toString();
        System.out.println("Insurance: " + text);
        
        StringJoiner joiner1 = new StringJoiner("::","[","]");
        joiner1.add("A");
        joiner1.add("B");
        StringJoiner joiner2 = new StringJoiner("|","{","}");
        
        joiner2.add("C");
        joiner2.add("D");
        
        System.out.println(joiner1.merge(joiner2));
    }
}
