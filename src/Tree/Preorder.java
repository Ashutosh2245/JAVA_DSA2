package Tree;
import java.util.*;
public class Preorder {
    public static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(int[] arr){
        if(arr.length == 0 || arr[0] == -1) return null;

        Queue <Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length){
            Node curr = q.poll();

            if(i < arr.length && arr[i] != -1){
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            if(i < arr.length && arr[i] != -1){
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;

    }

    static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = buildTree(arr);
        System.out.println("Preorder:");
        preorder(root);
    }
}

