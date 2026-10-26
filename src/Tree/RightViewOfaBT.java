package Tree;
import java.util.*;
public class RightViewOfaBT {
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
    public static ArrayList <Integer> rightView(Node root){

        ArrayList <Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue <Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node curr = q.poll();

                if(i == n-1) ans.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node root = buildTree(arr);
        ArrayList <Integer> ans = rightView(root);

        for(int ele : ans){
            System.out.print(ele + " ");
        }
    }
}
