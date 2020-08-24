package VerkeerSituatie.AnD;


import VerkeerSituatie.Voertuig.Voertuig;

public class LinkPriority {

    LinkPriorityLinkList LinkPriorityLinkList;
   private  int nItems;


    public LinkPriority() {
        LinkPriorityLinkList = new LinkPriorityLinkList();
    }


    public void insert(Voertuig voertuig) {
        LinkPriorityLinkList.insert(voertuig);
        nItems++;
    }


    public Voertuig remove() {
        if (isEmpty()){
            return null;
        }
        nItems--;
        return LinkPriorityLinkList.deleteFirst();
    }

    public int getnItems(){
        return nItems;
    }


    public boolean isEmpty() {
        return (LinkPriorityLinkList.isEmpty());
    }

    public void displayQueue() {
        System.out.print("\n"+"----------------------------------------------Speciale Voertuigen met Sirene-----------------------------------------------------"+"\n");
        LinkPriorityLinkList.displayList();
    }

}
