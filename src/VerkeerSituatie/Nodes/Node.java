package VerkeerSituatie.Nodes;

import VerkeerSituatie.Voertuig.Voertuig;

public class Node {
   public Voertuig voertuig;
   public Node next ;

    public Node (Voertuig voertuig){
        this.voertuig=voertuig;
    }

    public void displayLink() {
        System.out.print("\n"+"Volg nummer: "+voertuig.getVolgNo()+", Kentekenplaat: "+ voertuig.getKentekenPlaat()+", Prioriteit indicator: "+voertuig.getPriorityNo());
    }
}
