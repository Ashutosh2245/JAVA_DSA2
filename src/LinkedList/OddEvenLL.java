package LinkedList;
import java.util.*;
public class OddEvenLL {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static Node oddEvenLL(Node head){
        if(head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void print(Node head){
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
        print(head);
        System.out.println();
        Node ans = oddEvenLL(head);
        print(ans);
    }
}
