package Tree;
import java.util.*;
public class SubTreeOrNot {
    public static class Node{
        int val;
        Node left, right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isSubtree(Node root1, Node root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        if (isSame(root1, root2)) return true;

        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private static boolean isSame(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    public static Node buildBST(int[] arr){
        int n = arr.length;

        if (n == 0 || arr[0] == -1) return null;

        Queue <Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);

        q.add(root);

        int i = 1;

        while (!q.isEmpty()){
            Node curr = q.remove();

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

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {2,4,5};

        Node root1 = buildBST(arr1);
        Node root2 = buildBST(arr2);

        System.out.println(isSubtree(root1, root2));

    }
}