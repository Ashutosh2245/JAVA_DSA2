package Tree;
import java.util.*;
public class ReverseEvenLevelsOfBT {
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
    public static Node reverseEvenLevels(Node root){
        if(root == null) return null;
        reverse(root.left, root.right, 1);
        return root;

    }
    public static void reverse(Node left, Node right, int lvl){
        if(left == null || right == null) return;

        if(lvl %2 == 0){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        reverse(left.left, right.right, lvl+1);
        reverse(left.right, right.left, lvl+1);
    }
    public static void printBt(Node root){
        if(root == null) return;
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
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Node root = buildTree(arr);
        printBt(root);
        System.out.println();

        root = reverseEvenLevels(root);
        printBt(root);
    }
}
