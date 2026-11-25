import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;
    private ArrayList<Node> list = new ArrayList<>();

    public BST() {
        root = null;
    }

    public BST(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int key) {
        insert(new Node(key, null));
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
            list.add(root);
        } else {
            Node current = root;
            Node parent = null;

            while (current != null) {
                parent = current;
                if (node.getKey() < current.getKey()) {
                    current = current.getLeft();
                }
                else {
                    current = current.getRight();
                }
            }

            node.setParent(parent);
            if (node.getKey() < parent.getKey()) {
                parent.setLeft(node);
            }
            else {
                parent.setRight(node);
            }
            list.add(node);
        }
    }

    public boolean delete(int key) {
        Node node = getNode(key);
        if (node == null) {
            return false;
        }
        return delete(node);
    }

    public boolean delete(Node node) {
        if (node == null || !list.contains(node)) {
            return false;
        }

        int count = node.getCount();
        if (count > 1) {
            node.setCount(count - 1);
            return true;
        }

        boolean isLeft = node.getParent().getLeft() == node;
        if (node.getLeft() == null && node.getRight() == null) {
            if (isLeft) {
                node.getParent().setLeft(null);
            }
            else {
                node.getParent().setRight(null);
            }
            list.remove(node);
            return true;
        } else if (node.getLeft() == null) {
            if (isLeft) {
                node.getParent().setLeft(node.getRight());
                node.getRight().setParent(node.getParent());
            }
            else {
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getParent());
            }
            list.remove(node);
            return true;
        } else if (node.getRight() == null) {
            if (isLeft) {
                node.getParent().setLeft(node.getLeft());
                node.getLeft().setParent(node.getParent());
            }
            else {
                node.getParent().setRight(node.getLeft());
                node.getLeft().setParent(node.getParent());
            }
            list.remove(node);
            return true;
        } else {
            if (isLeft) {
                node.getParent().setLeft(node.getRight());
                node.getRight().setParent(node.getParent());
                node.getLeft().setParent(node.getRight());
            }
            else {
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getParent());
                node.getLeft().setParent(node.getRight());
            }
            list.remove(node);
            return true;
        }
    }

    public Node getNode(int key) {
        for (Node node : list) {
            if (node.getKey() == key) {
                return node;
            }
        }
        return null;
    }

    public ArrayList<Node> getInOrder() {
        return getInOrder(root);
    }

    public ArrayList<Node> getInOrder(Node root) {
        ArrayList<Node> inOrder = new ArrayList<>();
        if (root != null && list.contains(root)) {
            inOrder.addAll(getInOrder(root.getLeft()));
            inOrder.add(root);
            inOrder.addAll(getInOrder(root.getRight()));
        }
        return inOrder;
    }

    public ArrayList<Node> getPreOrder() {
        return getPreOrder(root);
    }    

    public ArrayList<Node> getPreOrder(Node root) {
        ArrayList<Node> preOrder = new ArrayList<>();
        if (root != null && list.contains(root)) {
            preOrder.add(root);
            preOrder.addAll(getPreOrder(root.getLeft()));
            preOrder.addAll(getPreOrder(root.getRight()));
        }
        return preOrder;
    }

    public ArrayList<Node> getPostOrder() {
        return getPostOrder(root);
    }

    public ArrayList<Node> getPostOrder(Node root) {
        ArrayList<Node> postOrder = new ArrayList<>();
        if (root != null && list.contains(root)) {
            postOrder.addAll(getPostOrder(root.getLeft()));
            postOrder.addAll(getPostOrder(root.getRight()));
            postOrder.add(root);
        }
        return postOrder;
    }

    public ArrayList<Node> getLevelOrder() {
        return getLevelOrder(root);
    }

    public ArrayList<Node> getLevelOrder(Node root) {
        ArrayList<Node> levelOrder = new ArrayList<>();
        if (root != null && list.contains(root)) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.remove();
                levelOrder.add(current);

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
        return levelOrder;
    }

    public void print() {
        print(root);
    }

    public void print(Node start) {
        if (start != null && list.contains(start)) {
            System.out.println(start.getKey() + "(" + start.getCount() + ")");
            // finish this
        }
    }
}