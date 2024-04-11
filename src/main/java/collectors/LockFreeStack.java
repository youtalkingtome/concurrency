package collectors;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack<T> {
    private static class Node<T> {
        final T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private AtomicReference<Node<T>> top = new AtomicReference<>();

    public void push(T value) {
        Node<T> newHead = new Node<>(value);
        Node<T> oldHead;
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }

    public T pop() {
        Node<T> oldHead;
        Node<T> newHead;
        do {
            oldHead = top.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));
        return oldHead.value;
    }
    public boolean isEmpty() {
        Node<T> oldTop = top.get();
        if (oldTop == null) {
            return true;
        } else {
            // Attempt to pop
            Node<T> newTop = oldTop.next;
            if (top.compareAndSet(oldTop, newTop)) {
                // Successfully popped, push back if needed
                // This is where you'd push the oldTop back onto the stack if necessary
                // but this operation can lead to issues as described.
                return false;
            } else {
                // Failed to pop, meaning the stack was modified concurrently
                return isEmpty(); // Retry or return false indicating uncertainty
            }
        }
    }


    public static void main(String[] args) {
        LockFreeStack<Integer> stack = new LockFreeStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop()); // Prints 2
        System.out.println(stack.pop()); // Prints 1
    }
}
