package VerkeerSituatie.AnD;

import VerkeerSituatie.Nodes.Node;
import VerkeerSituatie.Voertuig.Voertuig;

public class MainLinkList {

    private Node first;

    public MainLinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Voertuig voertuig) {
        Node newLink = new Node(voertuig);
        Node previous = null;
        Node current = first;

        while (current != null && voertuig.getVolgNo() > current.voertuig.getVolgNo()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            newLink.next = first;
            first = newLink;
        } else {
            previous.next = newLink;
            newLink.next = current;
        }
    }

    public Voertuig deleteFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node temp = first;
            first = first.next;
            return temp.voertuig;
        }
    }


    public Voertuig deleteWithValue ( int i) {
        if (first == null) {
            return null;
        }
        if (first.voertuig.getPriorityNo() == i) {
            first = first.next;
        }

        Node current = first;

        while (current.next != null) {

            if (current.next.voertuig.getPriorityNo() == i) {
                Voertuig deleted = current.next.voertuig;
                current.next = current.next.next;
                return deleted;

            }
            current = current.next;

        }return null;

    }

    public void displayList()
    {
        Node current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }


}
