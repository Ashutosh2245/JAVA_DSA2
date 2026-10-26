package LinkedList;
import java.util.*;
public class ReversePartOfaLinkedList {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    static Node successor;
    public static Node reverseLL(Node head, int n){
        if(head == null || n == 1){
            successor = head.next;
            return head;
        }

        Node newHead = reverseLL(head.next, n-1);
        head.next.next = head;
        head.next = successor;

        return newHead;
    }

    public static Node reversePartOfLL(Node head, int st, int end){
        if(head == null || st == end) return head;
        if(st > 1){
            head.next = reversePartOfLL(head.next, st-1, end-1);
            return head;
        }

        return reverseLL(head, end);
    }

    public static void print(Node head){
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
        print(head);
        System.out.println();
        int st = sc.nextInt();
        int end = sc.nextInt();
        Node reversed = reversePartOfLL(head, st, end);
        print(reversed);

    }
}
