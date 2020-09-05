package Questions.Trees_11;

public class BT2DLL {
    public static void main(String[] args) {
        Height.Node root = new Height.Node(17);
        root.left = new Height.Node(24);
        root.right = new Height.Node(10);
        root.left.left = new Height.Node(15);
        root.left.right = new Height.Node(28);
        root.left.left.left = new Height.Node(4);
        root.left.left.right = new Height.Node(4);
        root.right.right = new Height.Node(29);

    }
}
