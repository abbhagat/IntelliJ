package lld.arraylist;

public class ArrayListImpl {

  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>(10);
    al.add(0);
    al.add(1);
    al.add(2);
    al.add(3);
    al.add(4);
    al.add(5);
    al.add(6);
    al.add(7);
    al.add(8);
    al.add(9);
    for (int i = 0; i < al.getSize(); i++) {
      System.out.println(al.get(i));
    }
    al.remove(8);
    System.out.println("Changed List");
    for (int i = 0; i < al.getSize(); i++) {
      System.out.println(al.get(i));
    }
    System.out.println();
    Object[] obj = al.getList();
    for (Object o : obj) {
      System.out.println(o);
    }
  }
}
