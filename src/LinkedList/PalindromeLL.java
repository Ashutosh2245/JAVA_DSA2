package LinkedList;
import java.util.*;
public class PalindromeLL {
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
    public static boolean palindromeLL(Node head){
        if(head == null || head.next == null) return true;

        Node middle = middle(head);
        Node secondHalf = reverse(middle.next);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
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

        System.out.println("Palindrome LL: "+palindromeLL(head));
    }
}
