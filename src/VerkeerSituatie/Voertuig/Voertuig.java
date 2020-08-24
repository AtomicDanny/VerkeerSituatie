package VerkeerSituatie.Voertuig;

public class Voertuig {
    int volgNo;
    String kentekenPlaat;
    int PriorityNo;

    public  Voertuig (int volgNo, String kentekenPlaat,int PriorityNo){
        this.volgNo= volgNo;
        this.PriorityNo= PriorityNo;
        this.kentekenPlaat = kentekenPlaat ;
    }

    public String getKentekenPlaat(){
        return kentekenPlaat;
    }

    public int getVolgNo (){
        return volgNo;
    }

    public int getPriorityNo(){
        return PriorityNo;
    }

}
