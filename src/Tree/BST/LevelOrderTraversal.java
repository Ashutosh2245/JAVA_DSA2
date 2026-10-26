package Tree.BST;
import java.util.*;

public class LevelOrderTraversal {
    public static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node build(int[] arr){
        int n = arr.length;
        if(n==0 || arr[0] == -1) return null;

        Queue <Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;
        while (!q.isEmpty()){
            Node curr = q.poll();

            if(i<n && arr[i] != -1){
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            if(i<n && arr[i] != -1){
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static int height(Node root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static void printLevel(Node root, int level, ArrayList<Integer> ans) {
        if (root == null) return;

        if (level == 1) {
            ans.add(root.data);
        }
        else {
            printLevel(root.left, level - 1, ans);
            printLevel(root.right, level - 1, ans);
        }
    }

    static ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        int h = height(root);

        for (int i = 1; i <= h; i++) {
            printLevel(root, i, ans);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,-1,-1,6,7};
        Node root = build(arr);
        ArrayList <Integer> ans = levelOrder(root);

        for (int ele : ans) System.out.print(ele + " ");
    }
}