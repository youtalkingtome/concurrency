package collectors.algorithms;

class ListNodeClass {
    int val;
    ListNodeClass next;

    ListNodeClass(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DetectCyclesInList {
    public boolean listHasCycle(ListNodeClass head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNodeClass slowPointer = head;
        ListNodeClass fastPointer = head.next;

        while (slowPointer != fastPointer) {
            if (fastPointer == null || fastPointer.next == null) {
                return false; // No cycle
            }
            slowPointer = slowPointer.next; // Move slowPointer pointer by one step
            fastPointer = fastPointer.next.next; // Move fastPointer pointer by two steps
        }

        return true; // Cycle detected
    }

    public static void main(String[] args) {
        DetectCyclesInList detector = new DetectCyclesInList();
        // Example usage:
        ListNodeClass head = new ListNodeClass(3);
        head.next = new ListNodeClass(2);
        head.next.next = new ListNodeClass(0);
        head.next.next.next = new ListNodeClass(-4);

        // Create a cycle (4th node points back to the 2nd node)
        head.next.next.next.next = head.next;

        System.out.println("Does the linked list contain a cycle? " + detector.listHasCycle(head));
    }
}
