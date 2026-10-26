package Tree;
import java.util.LinkedList;
import java.util.Queue;
public class DiameterOfBt {
    static int diameter;
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

        Queue<Node> q = new LinkedList<>();
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
        int leftH = height(root.left);
        int rightH = height(root.right);

        diameter = Math.max(diameter, leftH+rightH+2);
        return 1 + Math.max(leftH, rightH);
    }

    public static int dia(Node root){
        if(root == null) return 0;
        diameter = 0;
        height(root);
        return diameter;
    }
//    public static int diameter(Node root){
//        if(root == null) return 0;
//
//        int leftD = diameter(root.left);
//        int rightD = diameter(root.right);
//        int sp =
//    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Node root = build(arr);
        System.out.println(dia(root));
    }
}
