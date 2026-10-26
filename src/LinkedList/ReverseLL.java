package LinkedList;
import java.util.*;
public class ReverseLL {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;

        Node newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void printLL(Node head){
        if(head == null) return;

        Node temp = head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
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
        printLL(head);
        System.out.println();
        Node rev = reverse(head);
        printLL(rev);

    }
}
