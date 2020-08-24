package VerkeerSituatie.Wegdek;



import VerkeerSituatie.AnD.LinkStack;
import VerkeerSituatie.AnD.MainLinkPriority;
import VerkeerSituatie.Voertuig.Voertuig;

public class Wegdek {

    private String CardinalDirection ;
    private MainLinkPriority voertuigMain = new MainLinkPriority();
    private LinkStack voertuigTemp = new LinkStack();


    public Wegdek(String CardinalDirection){
        this.CardinalDirection=CardinalDirection;
    }

    public void insertIntoWegdek(Voertuig voertuig ){
        voertuigMain.insert(voertuig);
    }

    public MainLinkPriority getVoertuigMain(){
        return voertuigMain;
    }

    public LinkStack getVoertuigTemp(){
        return voertuigTemp;
    }

    public String getCardinalDirection(){
        return CardinalDirection;
    }

}
