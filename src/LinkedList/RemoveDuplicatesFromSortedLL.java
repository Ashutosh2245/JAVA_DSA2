package LinkedList;
import java.util.*;
public class RemoveDuplicatesFromSortedLL {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static Node removeDuplicates(Node head){
        Node curr = head;

        while (curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            else curr = curr.next;
        }
        return head;
    }

    public static void print(Node head){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node head = new Node(sc.nextInt());
        Node curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new Node(sc.nextInt());
            curr = curr.next;
        }
        print(head);
        System.out.println();

        Node ans = removeDuplicates(head);
        print(ans);
    }
}
