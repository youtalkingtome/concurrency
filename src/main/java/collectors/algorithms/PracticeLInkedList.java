package collectors.algorithms;


public class PracticeLInkedList {

    Node head;

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
    public void deleteNode(int data)
    {
        Node current=head;
        Node previous=null;
        while(current !=null && current.data !=data)
        {
         previous=current;
         current=current.next;
        }
        if(current ==null )
        {
            System.out.println("Node with value " + data + " not found.");
            return;
        }
        if(previous == null)
        {
         head=head.next;
        }
        else {
            previous.next=current.next;
        }

    }


    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }

    }
}
