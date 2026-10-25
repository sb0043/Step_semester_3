
package week10.assignment_problems;

public class CancelledOrdersCleanup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node removeAll(Node head, int code) {
        // Remove matching nodes from the beginning.
        while (head != null && head.data == code) {
            head = head.next;
        }

        // Remove matching nodes from the rest of the list.
        Node current = head;

        while (current != null && current.next != null) {
            if (current.next.data == code) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    static void display(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println("null");
    }

    static Node createList(int[] values) {
        Node head = null;
        Node tail = null;

        for (int value : values) {
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = createList(new int[]{5, 3, 5, 8, 5});

        head = removeAll(head, 5);
        display(head);

        Node allCancelled = createList(new int[]{5, 5, 5});

        allCancelled = removeAll(allCancelled, 5);
        display(allCancelled);
    }
}
