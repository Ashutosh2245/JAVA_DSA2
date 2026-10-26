package Tree.BST;
import java.util.*;
public class InsertInBST {
    public static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int val){
        if (root == null) return new Node(val);
        if(val < root.val) root.left = insert(root.left, val);
        if(val > root.val) root.right = insert(root.right, val);
        return root;
    }
    public static Node buildBST(int[] arr){
        int n = arr.length;
        if(n == 0 || arr[0] == -1) return null;
        Node root = null;

        for (int i = 0; i < n; i++) {
            if(arr[i] != -1) root = insert(root, arr[i]);
        }
        return root;
    }
    public static void levelOrder(Node root){
        if (root == null) return;
        Queue <Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            Node curr = q.poll();

            System.out.print(curr.val + " ");

            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,-1,2,3,-1,4,5};
        Node root = buildBST(arr);
        levelOrder(root);
        int val = 6;
        System.out.println();
        root = insert(root, val);
        levelOrder(root);
    }
}
