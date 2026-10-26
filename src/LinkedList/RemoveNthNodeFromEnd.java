package LinkedList;
import java.util.*;
public class RemoveNthNodeFromEnd {
    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static Node removeNthFromEnd(Node head, int n){
        if(head == null) return null;

        Node temp = new Node(0);
        temp.next = head;

        Node slow = temp;
        Node fast = temp;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+ " ");
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

        int N = sc.nextInt();
        Node ans = removeNthFromEnd(head, N);
        print(ans);
    }
}
