package collectors.algorithms;

public class FindPalindromeInList {

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        // Create an instance of the Solution class
        FindPalindromeInList solution = new FindPalindromeInList();

        // Test the isPalindrome method
        boolean result = solution.isPalindrome(head);

        // Print the result
        System.out.println("Is the linked list a palindrome? " + result);
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true; // an empty list or a list with one node is considered a palindrome

        // Find the middle of the linked list using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverseList(slow);

        // Compare the first half with the reversed second half
        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val)
                return false; // if values are not equal, it's not a palindrome

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    static class  ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
