package VerkeerSituatie.KruisingService;


import VerkeerSituatie.AnD.BinaryTree;
import VerkeerSituatie.AnD.LinkPriority;
import VerkeerSituatie.AnD.LinkStack;
import VerkeerSituatie.Voertuig.Voertuig;
import VerkeerSituatie.Wegdek.Wegdek;

public class Kruising {

    public static final char[] Stoplicht = {'N', 'Z', 'O', 'W'};

    public static  Wegdek[] WEGDEK = {new Wegdek("Noord"), new Wegdek("Zuid"), new Wegdek("Oost"), new Wegdek("West")};

    public static final String[] specialeVoertuigen= {"Politie","Brandweer","Ambulance"};

    private static int aantalRondes;

    private LinkPriority priority = new LinkPriority();
    private BinaryTree voertuigBinary = new BinaryTree();
    private LinkStack linkStack = new LinkStack();



    public void run (){
        sirene();
        trafficLightControl();
        getRondes();
        reversePlayBack();
        displayWegdekken();
        binaryTreeInsert();
    }

    public void sirene() {
        for (int wegdekIndex = 0; wegdekIndex < Stoplicht.length; wegdekIndex++) {
            for (int i = 0; i < specialeVoertuigen.length; i++) {
                Voertuig priorityVoertuig = WEGDEK[wegdekIndex].getVoertuigMain().removePriority(i);
                if (priorityVoertuig != null) {
                    WEGDEK[wegdekIndex].getVoertuigTemp().push(priorityVoertuig);
                    priority.insert(priorityVoertuig);

                }
            }
        }
        priority.displayQueue();
        int items = priority.getnItems();
        for (int j = 0; j <items ; j++) {
            Voertuig voertuig= priority.remove();
            linkStack.push(voertuig);
        }

    }

    public void trafficLightControl() {
        System.out.println("\n"+"----------------------------------------------Verkeersronde-----------------------------------------------------");
        for (int wegdekIndex = 0; wegdekIndex < Stoplicht.length; wegdekIndex++) {
            switch (wegdekIndex) {
                case 0:
                    if (checkWegdekEmpty(WEGDEK[wegdekIndex])) {
                        System.out.println("\n"+"Sensor " + WEGDEK[wegdekIndex].getCardinalDirection() +": Wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " is leeg");
                        }
                    else {
                        System.out.println("\n"+"Groen licht, de voertuigen van wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " mogen rijden"+"\n");
                        sensorNoord(WEGDEK[wegdekIndex]);
                    }
                    break;
                case 1:
                    if (checkWegdekEmpty(WEGDEK[wegdekIndex])) {
                        System.out.println("\n"+"Sensor " + WEGDEK[wegdekIndex].getCardinalDirection() +": Wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " is leeg");
                    }
                    else {
                        System.out.println("\n"+"Groen licht, de voertuigen van wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " mogen rijden"+"\n");
                        sensorZuid(WEGDEK[wegdekIndex]);
                    }
                    break;
                case 2:
                    if (checkWegdekEmpty(WEGDEK[wegdekIndex])) {
                        System.out.println("\n"+"Sensor " + WEGDEK[wegdekIndex].getCardinalDirection() +": Wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " is leeg, groen licht beurt overslaan");
                    }
                    else {
                        System.out.println("\n"+"Groen licht, de voertuigen van wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " mogen rijden"+"\n");
                        sensorOost(WEGDEK[wegdekIndex]);}
                    break;
                case 3:
                    if (checkWegdekEmpty(WEGDEK[wegdekIndex])) {
                        System.out.println("\n"+"Sensor " + WEGDEK[wegdekIndex].getCardinalDirection() +": Wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " is leeg, groen licht beurt overslaan");
                        if (checkWegdekEmpty(WEGDEK[0]) && checkWegdekEmpty(WEGDEK[1]) && checkWegdekEmpty(WEGDEK[2]) && checkWegdekEmpty(WEGDEK[3])) {
                            System.out.println("\n"+"Er zijn geen voertuigen (meer) op de wegdekken");
                            break;
                        } else {
                            wegdekIndex = -1;
                            aantalRondes++;
                        }
                    }
                    else {
                        System.out.println("\n"+"Groen licht, de voertuigen van wegdek " + WEGDEK[wegdekIndex].getCardinalDirection() + " mogen rijden"+"\n");
                        sensorWest(WEGDEK[wegdekIndex]);
                        wegdekIndex = -1;
                        aantalRondes++;}
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        }
    }

    public void reversePlayBack() {
        System.out.println("\n" + "----------------------------------------------Reverse Playback-----------------------------------------------------");
        System.out.println("\n"+ "Voertuigen rijden een voor een terug"+"\n");
        int items = linkStack.getnItems();
        for (int i = 0; i < items; i++) {
            Voertuig voertuigStack = linkStack.pop();
            System.out.println("Volg nummer: " + voertuigStack.getVolgNo() + ", Kentekeplaat:" + voertuigStack.getKentekenPlaat() + ", Prioiriteit indicator: " + voertuigStack.getPriorityNo());
        }
        for (int wegdekIndex = 0; wegdekIndex < Stoplicht.length; wegdekIndex++) {
                int items2 = WEGDEK[wegdekIndex].getVoertuigTemp().getnItems();
                for (int j = 0; j < items2; j++) {
                    Voertuig voertuig = WEGDEK[wegdekIndex].getVoertuigTemp().pop();
                    WEGDEK[wegdekIndex].getVoertuigMain().insert(voertuig);
                    if (WEGDEK[wegdekIndex].getVoertuigTemp().isEmpty()) {
                        break;
                    }
                }
            }

        }




    public void binaryTreeInsert()  {
        System.out.println("\n"+"----------------------------------------------Binary Tree-----------------------------------------------------");
        for (int wegdekIndex = 0; wegdekIndex < Stoplicht.length; wegdekIndex++) {
            int items = WEGDEK[wegdekIndex].getVoertuigMain().getnItems();
            for (int i = 0; i < items; i++) {
                Voertuig voertuig = WEGDEK[wegdekIndex].getVoertuigMain().remove();
                voertuigBinary.insert(voertuig);
                if (WEGDEK[wegdekIndex].getVoertuigMain().isEmpty()) {
                    break;
                }
            }
        }
        System.out.println("\n"+"Alle Voertuigen zijn succesvol in een binary tree geplaatst"+"\n"+"U mag uw voertuig opzoeken");
//        System.out.println("\n"+"Traverse Binary Tree:"+"\n");
//        Traversal();
    }

    public void TreeSearch(String kentekenPlaat){
        voertuigBinary.search(kentekenPlaat);
    }

    public void Traversal(){
        voertuigBinary.inorder();
    }

    private void sensorNoord(Wegdek wegdek) {
        if (wegdek.getVoertuigMain().getnItems() < 5) {
            int items = wegdek.getVoertuigMain().getnItems();
            for (int i = 0; i < items; i++) {
                drive(wegdek);
                if (checkWegdekEmpty(wegdek)) {
                    System.out.println("Wegdek " + wegdek.getCardinalDirection() + " is leeg");
                    break;
                }
            }
            System.out.println("\n"+"Oranje licht....Rood licht op wegdek "+wegdek.getCardinalDirection()+"  !!Stop!!");
        } else {
            noSensorDrive(wegdek);
        }
    }

    private void sensorZuid(Wegdek wegdek) {
        checkMoreThanTen(wegdek);
    }

    private void sensorOost(Wegdek wegdek) {
        noSensorDrive(wegdek);
    }

    private void sensorWest(Wegdek wegdek) {
        checkMoreThanTen(wegdek);
    }

    private void drive(Wegdek wegdek) {
        Voertuig voertuig = wegdek.getVoertuigMain().remove();
        System.out.println("Volg nummer: " + voertuig.getVolgNo() + ", Kentekeplaat: " + voertuig.getKentekenPlaat()+", Prioiriteit indicator: "+voertuig.getPriorityNo());
        wegdek.getVoertuigTemp().push(voertuig);
        linkStack.push(voertuig);
    }

    private void noSensorDrive(Wegdek wegdek) {
        for (int i = 0; i < 5; i++) {
            drive(wegdek);
            if (checkWegdekEmpty(wegdek)) {
                break;
            }
        }
        System.out.println("\n"+"Oranje licht....Rood licht op wegdek "+wegdek.getCardinalDirection()+"  !!Stop!!");
    }

    private void checkMoreThanTen(Wegdek wegdek) {
        if (wegdek.getVoertuigMain().getnItems() > 10) {
            for (int i = 0; i < 10; i++) {
                drive(wegdek);
                if (checkWegdekEmpty(wegdek)) {
                    break;
                }
            }
            System.out.println("\n"+"Oranje licht....Rood licht op wegdek "+wegdek.getCardinalDirection()+"  !!Stop!!");
        } else {
            noSensorDrive(wegdek);
        }
    }

    public boolean checkWegdekEmpty(Wegdek wegdek) {
        return wegdek.getVoertuigMain().isEmpty();
    }

    public void displayWegdekken(){
        System.out.println("\n"+"--------------------------Check kruising als voertuigen op de juiste positie in hun wegdekken zijn--------------------------");
        System.out.println("\n"+WEGDEK[0].getCardinalDirection());
        WEGDEK[0].getVoertuigMain().displayQueue();
        System.out.println("\n"+WEGDEK[1].getCardinalDirection());
        WEGDEK[1].getVoertuigMain().displayQueue();
        System.out.println("\n"+WEGDEK[2].getCardinalDirection());
        WEGDEK[2].getVoertuigMain().displayQueue();
        System.out.println("\n"+WEGDEK[3].getCardinalDirection());
        WEGDEK[3].getVoertuigMain().displayQueue();

    }

    public void insertWegdekNoord(int volgNummer, String kentekenPlaat,int priorityNummer){
        WEGDEK[0].insertIntoWegdek(new Voertuig(volgNummer,kentekenPlaat,priorityNummer));
    }

    public void insertWegdekZuid(int volgNummer, String kentekenPlaat,int priorityNummer){
        WEGDEK[1].insertIntoWegdek(new Voertuig(volgNummer,kentekenPlaat,priorityNummer));
    }

    public void insertWegdekOost(int volgNummer, String kentekenPlaat,int priorityNummer){
        WEGDEK[2].insertIntoWegdek(new Voertuig(volgNummer,kentekenPlaat,priorityNummer));
    }

    public void insertWegdekWest(int volgNummer, String kentekenPlaat,int priorityNummer){
        WEGDEK[3].insertIntoWegdek(new Voertuig(volgNummer,kentekenPlaat,priorityNummer));
    }

    public void getRondes(){
        System.out.println("\n"+"Aantal verkeerslichten rondes tot lege wegdekken: "+ aantalRondes);
    }

}
