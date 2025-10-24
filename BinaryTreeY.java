import java.util.*;

public class BinaryTreeY {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static int countOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);

        return left + right + 1;
    }

    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);

        return left + right + root.data;
    }

    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        int result = Math.max(left, right);
        /*if(left>right) { 
            result = left;
        }
        else if(left == right) {
            result = right ;
        }
        else { 
            result = right;
        }*/
        return result + 1;
    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(countOfNodes(root));
        System.out.println(sumOfNodes(root));
        System.out.println(heightOfTree(root));
    }
}
