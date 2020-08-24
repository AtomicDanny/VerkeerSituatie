package VerkeerSituatie.AnD;

import VerkeerSituatie.Voertuig.Voertuig;

public class MainLinkPriority {


    MainLinkList mainLinkList;
    private static int nItems;


    public MainLinkPriority() {
        mainLinkList = new MainLinkList();
    }


    public void insert(Voertuig voertuig) {
        mainLinkList.insert(voertuig);
        nItems++;
    }


    public Voertuig remove() {
        if (isEmpty()){
            return null;
        }
        nItems--;
        return mainLinkList.deleteFirst();
    }

    public Voertuig removePriority(int i){
        return   mainLinkList.deleteWithValue(i);

    }


    public boolean isEmpty() {
        return (mainLinkList.isEmpty());
    }

    public void displayQueue() {
        mainLinkList.displayList();
    }

    public int getnItems(){
        return nItems;
    }



}
