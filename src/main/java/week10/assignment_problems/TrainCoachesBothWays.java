
package week10.assignment_problems;

public class TrainCoachesBothWays {

    static class Node {
        int coachNumber;
        Node previous;
        Node next;

        Node(int coachNumber) {
            this.coachNumber = coachNumber;
        }
    }

    static class Train {
        Node head;
        Node tail;

        void addCoach(int coachNumber) {
            Node newNode = new Node(coachNumber);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
        }

        void displayForward() {
            Node current = head;

            while (current != null) {
                System.out.print(current.coachNumber + "->");
                current = current.next;
            }

            System.out.println("null");
        }

        void displayBackward() {
            Node current = tail;

            while (current != null) {
                System.out.print(current.coachNumber + "->");
                current = current.previous;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Train train = new Train();

        train.addCoach(101);
        train.addCoach(102);
        train.addCoach(103);
        train.addCoach(104);

        System.out.print("Forward: ");
        train.displayForward();

        System.out.print("Backward: ");
        train.displayBackward();
    }
}
