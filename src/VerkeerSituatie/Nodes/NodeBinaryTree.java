package VerkeerSituatie.Nodes;


import VerkeerSituatie.Voertuig.Voertuig;

public class NodeBinaryTree {
    public String value ;
    public Voertuig voertuig;
    public NodeBinaryTree leftChild, rightChild;

   public NodeBinaryTree(Voertuig voertuig){
        this.voertuig = voertuig;
        this.value=voertuig.getKentekenPlaat();
    }

    public String getValue() {
        return value;
    }

    public void displayNode(){
        System.out.print("\n"+"Kentekenplaat: "+ voertuig.getKentekenPlaat()+" , Volg nummer: "+voertuig.getVolgNo()+" , Prioriteit nummer: "+voertuig.getPriorityNo()+"\n");

    }
}
