package Tree;
import java.util.*;
public class PathSumLC112 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    // Build Tree using -1 for NULL
    public static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1)
            return null;

        Queue<Node> q = new LinkedList<>();

        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            Node curr = q.poll();

            // Left
            if (i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            // Right
            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Path Sum
    public static boolean hasPathSum(Node root, int targetSum) {

        if (root == null) return false;

        // Leaf node
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) return true;
            else return false;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int targetSum = sc.nextInt();

        Node root = buildTree(arr);

        boolean ans = hasPathSum(root, targetSum);

        System.out.println(ans);
    }
}