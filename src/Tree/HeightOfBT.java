package Tree;
import java.util.*;
public class HeightOfBT {
    public static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
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
    public static int height(Node root){
        if(root == null) return -1; // No of edges
        return 1+ Math.max((height(root.left)), (height(root.right)));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Node root = build(arr);
        System.out.println(height(root));
    }
}
