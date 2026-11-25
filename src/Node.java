public class Node {
    private int key;
    private int count = 1;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int key, Node parent) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }

    public Node(int key, Node parent, int count) {
        this.key = key;
        if (count > 1) {
            this.count = count;
        }
        this.left = null;
        this.right = null;
    }

    public int getKey() {
        return this.key;
    }

    public int getCount() {
        return this.count;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}