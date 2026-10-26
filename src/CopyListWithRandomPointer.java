import java.util.*;
public class CopyListWithRandomPointer {
    public static class Node{
        int val;
        Node next, rand;
        Node(int val){
            this.val = val;
            this.next = null;
            this.rand = null;
        }
    }
    public static Node copyLL(Node head){
        if(head == null) return null;

        Node curr = head;
        while (curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null){
            if(curr.rand != null){
                curr.next.rand = curr.rand.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        while (curr != null){
            Node copy = curr.next;
            curr.next = copy.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }
        return newHead;
    }
    public static void printLL(Node head){
        if(head == null) return;
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

        printLL(head);
        System.out.println();

        Node result = copyLL(head);
        printLL(result);

    }
}
