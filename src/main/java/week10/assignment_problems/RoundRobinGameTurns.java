
package week10.assignment_problems;

public class RoundRobinGameTurns {

    static class Node {
        String player;
        Node next;

        Node(String player) {
            this.player = player;
        }
    }

    static class Game {
        Node current;

        void addPlayer(String player) {
            Node newNode = new Node(player);

            if (current == null) {
                current = newNode;
                newNode.next = newNode;
                return;
            }

            Node tail = current;

            while (tail.next != current) {
                tail = tail.next;
            }

            tail.next = newNode;
            newNode.next = current;
        }

        void playTurns(int numberOfTurns) {
            if (current == null) {
                System.out.println("No players");
                return;
            }

            for (int i = 0; i < numberOfTurns; i++) {
                System.out.println("Turn: " + current.player);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.addPlayer("Asha");
        game.addPlayer("Ravi");
        game.addPlayer("Neha");

        game.playTurns(7);
    }
}
