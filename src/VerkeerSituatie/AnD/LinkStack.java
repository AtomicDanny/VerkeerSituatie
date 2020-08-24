package VerkeerSituatie.AnD;

import VerkeerSituatie.Voertuig.Voertuig;

public class LinkStack {
    private LinkStackLinkList LinkStackLinkList;
    private  int nItems= 0;


    public LinkStack() {
        LinkStackLinkList = new LinkStackLinkList();
    }


    public void push(Voertuig voertuig) {
        LinkStackLinkList.insertFirst(voertuig);
        nItems++;
    }


    public Voertuig pop() {
        nItems--;
        return LinkStackLinkList.deleteFirst();

    }


    public boolean isEmpty() {
        return (LinkStackLinkList.isEmpty());
    }


    public int getnItems(){
        return nItems;
    }

}