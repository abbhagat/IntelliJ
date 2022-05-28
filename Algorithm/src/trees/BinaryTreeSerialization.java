package trees;

import java.util.List;

public class BinaryTreeSerialization {

    private static String serialize(Node root, String s){
        if(root == null){
            s += "null";
        }else{
            s += root.num   + ",";
            s += root.left  + ",";
            s += root.right + ",";
        }
        return s;
    }

    private static Node deserialize(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        Node root = new Node(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left  = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.right.left     = new Node(4);
        root.right.right    = new Node(5);
        System.out.println(serialize(root, ""));
        //System.out.println(deserialize(new ArrayList<>()));
    }
}
