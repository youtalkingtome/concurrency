package collectors.algorithms;

public class FindMiddleNode {
    public ListNode findMiddle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // Move slow pointer one step at a time and fast pointer two steps at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // At this point, slow pointer will be at the middle of the list
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}