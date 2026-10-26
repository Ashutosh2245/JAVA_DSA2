package Tree;
import java.util.*;
public class InvertBTLC226 {
    public static class Node{
        int val;
        Node left, right;

        Node(int val){
            this.val = val;
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

    public static Node invertBT(Node root){
        if(root == null) return null;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBT(root.left);
        invertBT(root.right);

        return root;
    }
    public static void levelOrder(Node root){
        if(root == null) return;

        Queue <Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            Node curr = q.poll();

            System.out.print(curr.val + " ");

            if(curr.left != null){
                q.add(curr.left);
            }

            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);
        levelOrder(root);
        System.out.println();

        invertBT(root);
        levelOrder(root);
    }
}
