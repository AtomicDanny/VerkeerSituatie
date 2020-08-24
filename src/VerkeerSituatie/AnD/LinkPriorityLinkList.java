package VerkeerSituatie.AnD;

import VerkeerSituatie.Nodes.Node;
import VerkeerSituatie.Voertuig.Voertuig;

public class LinkPriorityLinkList {

    private Node first;

    public LinkPriorityLinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Voertuig voertuig) {
        Node newLink = new Node(voertuig);
        Node previous = null;
        Node current = first;

        while (current != null && voertuig.getPriorityNo() > current.voertuig.getPriorityNo()) {
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

    public void displayList()
    {
        Node current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }


}

