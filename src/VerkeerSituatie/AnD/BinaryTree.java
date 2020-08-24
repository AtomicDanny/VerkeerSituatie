package VerkeerSituatie.AnD;

import VerkeerSituatie.Nodes.NodeBinaryTree;
import VerkeerSituatie.Voertuig.Voertuig;

public class BinaryTree {

    NodeBinaryTree root ;

 public BinaryTree(){
     root = null;
 }


 public void insert ( Voertuig voertuig ){
     root = insertVoertuig(root,voertuig);
 }

private NodeBinaryTree insertVoertuig (NodeBinaryTree root,Voertuig voertuig){

     if(root==null){
         root = new NodeBinaryTree(voertuig);
         return root;
     }

     if(voertuig.getKentekenPlaat().compareTo(root.getValue())<0){
         root.leftChild = insertVoertuig(root.leftChild, voertuig);
     }
     else{
         root.rightChild=insertVoertuig(root.rightChild,voertuig);
     }
     return root;
}

    public void search (String kentekenPlaat){
        searchTree(root,kentekenPlaat);
    }


private NodeBinaryTree searchTree(NodeBinaryTree root, String key){

     if (root==null|| root.value.equals(key)){
         if (root!=null){
             System.out.println("\n"+"Uw voertuig gegevens:");
         root.displayNode();
         return root;
         }else
         System.out.println("\n"+"Sorry, geen voertuig gevonden met die kentekenplaat");
         return null;
     }

     if(key.compareTo(root.getValue())<0){
         return searchTree(root.leftChild,key);
     }
     return searchTree(root.rightChild,key);
}

   public void inorder()  {
        inorderTraverse(root);
    }


   private void inorderTraverse(NodeBinaryTree root) {
        if (root != null) {
            inorderTraverse(root.leftChild);
            System.out.println(root.value);
            inorderTraverse(root.rightChild);
        }
    }





}








