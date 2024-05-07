package collectors.algorithms;


public class RemoveNthFromEnd {

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print original list
        System.out.println("Original list:");
        printLinkedList(head);

        // Remove the nth node from the end (here, n = 2)
        int n = 2;
        head = removeNthFromEnd(head, n);

        // Print modified list
        System.out.println("\nList after removing the " + n + "th node from the end:");
        printLinkedList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null)
                return null; // handle edge case
            fast = fast.next;
        }

        // Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node
        slow.next = slow.next.next;

        return dummy.next;
    }
    static class ListNode {
        int val;
     ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
