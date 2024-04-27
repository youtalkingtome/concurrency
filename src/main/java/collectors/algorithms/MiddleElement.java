package collectors.algorithms;

class ListNodeMiddle {
    int val;
    ListNodeMiddle next;

    ListNodeMiddle(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MiddleElement {
    public ListNodeMiddle findMiddle(ListNodeMiddle head) {
        if (head == null) {
            return null; // Empty list
        }

        ListNodeMiddle slow = head;
        ListNodeMiddle fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps
        }

        return slow; // Middle element or the second middle element in case of even number of nodes
    }

    public static void main(String[] args) {
        MiddleElement finder = new MiddleElement();

        // Example usage:
        ListNodeMiddle head = new ListNodeMiddle(1);
        head.next = new ListNodeMiddle(2);
        head.next.next = new ListNodeMiddle(3);
        head.next.next.next = new ListNodeMiddle(4);
        head.next.next.next.next = new ListNodeMiddle(5);

        ListNodeMiddle middle = finder.findMiddle(head);
        System.out.println("Middle element: " + middle.val);
    }
}
