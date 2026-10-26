import java.util.*;
public class LeftViewOfaBT {
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
        int n = arr.length;
        if(n == 0 || arr[0] == -1) return null;
        Queue <Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;
        while (!q.isEmpty()){
            Node curr = q.poll();

            if(i < n && arr[i] != -1){
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            if(i < n && arr[i] != -1){
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void printLeft(Node root){
        if(root == null) return;
        Queue <Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node curr = q.poll();

                if(i == 0) System.out.print(curr.val + " ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

        }
    }

    public static void printRight(Node root){
        if (root == null) return;
        Queue <Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node curr = q.poll();

                if(i == n-1) System.out.print(curr.val + " ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,-1,5,-1,-1,-1,-1,6,-1,7};
        Node root = buildTree(arr);
        printLeft(root);
        System.out.println();
        printRight(root);
    }
}
