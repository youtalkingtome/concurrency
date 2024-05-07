package collectors.algorithms;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList {
    Node head;  // head of list

    public void addNode(int data) {
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

    public void deleteNode(int data) {
        Node current = head;
        Node previous = null;

        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + data + " not found.");
            return;
        }

        if (previous == null) {
            // The node to be deleted is the head
            head = head.next;
        } else {
            // Bypass the current node
            previous.next = current.next;
        }
    }
    // Method to traverse the linked list
    public void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();

        myList.addNode(10);
        myList.addNode(20);
        myList.addNode(30);
        myList.addNode(40);
        System.out.println("Original List:");
        myList.printLinkedList();  // Output: 10 -> 20 -> 30 -> 40 -> null

        myList.deleteNode(30);
        System.out.println("List after deleting 30:");
        myList.printLinkedList();  // Output: 10 -> 20 -> 40 -> null

        myList.deleteNode(10);
        System.out.println("List after deleting the head (10):");
        myList.printLinkedList();  // Output: 20 -> 40 -> null
    }
}
