
package week10.assignment_problems;

public class ReverseTheQueue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node reverse(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
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

    static void display(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = createList(new int[]{1, 2, 3, 4});
        head = reverse(head);
        display(head);

        Node singleNode = createList(new int[]{9});
        singleNode = reverse(singleNode);
        display(singleNode);
    }
}
