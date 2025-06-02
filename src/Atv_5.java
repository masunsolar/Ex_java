import java.util.Scanner;

class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class Atv_5 {

    static Node reverseList(Node head) {
        Node current = head;
        Node newHead = null;

        while (current != null) {
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            newHead = current;
            current = temp;
        }

        return newHead;
    }

    static void printOdds(Node head) {
        System.out.print("Números ímpares: ");
        boolean found = false;
        for (Node current = head; current != null; current = current.next) {
            if (current.value % 2 != 0) {
                System.out.print(current.value + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("Nenhum número ímpar na lista.");
        }
        System.out.println();
    }

    static void printList(Node head) {
        System.out.print("Lista: ");
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.value + " ");
        }
        System.out.println();
    }

    static Node symmetricDifference(Node head1, Node head2) {
        Node resultHead = null;
        Node resultTail = null;

        for (Node current = head1; current != null; current = current.next) {
            if (!contains(head2, current.value)) {
                Node newNode = new Node(current.value);
                if (resultHead == null) {
                    resultHead = newNode;
                    resultTail = newNode;
                } else {
                    resultTail.next = newNode;
                    newNode.prev = resultTail;
                    resultTail = newNode;
                }
            }
        }

        for (Node current = head2; current != null; current = current.next) {
            if (!contains(head1, current.value)) {
                Node newNode = new Node(current.value);
                if (resultHead == null) {
                    resultHead = newNode;
                    resultTail = newNode;
                } else {
                    resultTail.next = newNode;
                    newNode.prev = resultTail;
                    resultTail = newNode;
                }
            }
        }

        return resultHead;
    }

    static boolean contains(Node head, int value) {
        for (Node current = head; current != null; current = current.next) {
            if (current.value == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head1 = null;
        Node tail1 = null;

        System.out.println("Informe os 10 primeiros números inteiros:");

        for (int i = 0; i < 10; i++) {
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head1 == null) {
                head1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                newNode.prev = tail1;
                tail1 = newNode;
            }
        }

        System.out.println("\n=== Lista de Números Ímpares da Primeira Lista ===");
        if (head1 != null) {
            printOdds(head1);
        } else {
            System.out.println("Nenhum número ímpar foi inserido.");
        }

        head1 = reverseList(head1);
        System.out.println("\n=== Primeira Lista Invertida ===");
        printList(head1);

        Node head2 = null;
        Node tail2 = null;

        System.out.println("\nInforme os 10 segundos números inteiros:");

        for (int i = 0; i < 10; i++) {
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                newNode.prev = tail2;
                tail2 = newNode;
            }
        }

        if (head1 != null && head2 != null) {
            Node temp = head1;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head2;
            head2.prev = temp;
        }

        System.out.println("\n=== Lista Concatenada ===");
        printList(head1);

        Node result = symmetricDifference(head1, head2);
        System.out.println("\n=== Diferença Simétrica das Listas ===");
        printList(result);
    }
}