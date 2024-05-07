package collectors.algorithms;

public class ReverseLinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void reverseIterative() {
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;  // Store next node
            current.next = previous;  // Reverse current node's pointer
            previous = current;  // Move pointers one position ahead
            current = next;
        }
        head = previous;  // Reset head to the new front of the list
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList myList = new ReverseLinkedList();

        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);

        System.out.println("Original List:");
        myList.printList();  // Output: 10 -> 20 -> 30 -> 40 -> null

        myList.reverseIterative();
        System.out.println("Reversed List (Iterative):");
        myList.printList();  // Output: 40 -> 30 -> 20 -> 10 -> null

        System.out.println("Reversed List (Recursive):");
        myList.printList();  // Output: 10 -> 20 -> 30 -> 40 -> null
    }

    static class Node {
        int data;
       Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
