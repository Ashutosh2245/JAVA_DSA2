package Tree;
import java.util.*;
public class SameTreeLC100 {
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

    public static boolean isSameTree(Node p, Node q){
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        Node root1 = buildTree(arr1);
        Node root2 = buildTree(arr2);

        System.out.println(isSameTree(root1, root2));
    }
}
