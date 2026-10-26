package Tree;

import java.util.*;

public class CountNodesLC222 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static Node buildTree(int[] arr) {

        if(arr.length == 0 || arr[0] == -1)
            return null;

        Queue<Node> q = new LinkedList<>();

        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;

        while(!q.isEmpty() && i < arr.length) {

            Node curr = q.poll();

            // Left
            if(i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            // Right
            if(i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static int countNodes(Node root) {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        int ans = countNodes(root);

        System.out.println(ans);
    }
}