package VerkeerSituatie.AnD;

import VerkeerSituatie.Nodes.Node;
import VerkeerSituatie.Voertuig.Voertuig;

public class LinkStackLinkList {
    private Node first;

    public LinkStackLinkList() {
        first = null; }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(Voertuig voertuig) {
        Node newLink = new Node(voertuig);
        newLink.next = first;
        first = newLink;
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

}

