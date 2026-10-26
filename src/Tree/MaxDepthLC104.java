package Tree;
import java.util.*;
public class MaxDepthLC104 {
    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
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
    public static int maxDepth(Node root){
        if(root == null) return 0;
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);

        return 1 + Math.max(leftD, rightD);
    }

    public static int minDepth(Node root){
        if(root == null) return 0;
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);

        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(leftD, rightD);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);
        int minD = minDepth(root);
        int maxD = maxDepth(root);

        System.out.println(minD + " " + maxD);
    }
}
