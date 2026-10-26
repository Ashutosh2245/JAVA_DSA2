package LinkedList;
import java.util.*;
public class MiddleOfLinkedList {
    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static Node middle(Node head){
        if(head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printLL(Node head){
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

        Node mid = middle(head);
        System.out.println(mid.val);
    }
}
