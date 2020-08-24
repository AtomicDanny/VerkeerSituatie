package VerkeerSituatie.App;


import VerkeerSituatie.KruisingService.Kruising;

public class App {
    public static void main(String[] args) {

        Kruising x = new Kruising();

        /*-------------------------N O O R D----------------------------*/

        x.insertWegdekNoord(1,"pm5000", 10);
        x.insertWegdekNoord(2,"pg1000", 20);
        x.insertWegdekNoord(3,"Ambulance",  2);
        x.insertWegdekNoord(4,"pz9000",  30);


        /*---------------------------Z U I D------------------------*/

        x.insertWegdekZuid(10,"pm4999",  130);
        x.insertWegdekZuid(2, "pm4998", 50);
        x.insertWegdekZuid(3,"pm6000",  60);
        x.insertWegdekZuid(4, "pm7000", 70);
        x.insertWegdekZuid(16,"pm9000", 190);
        x.insertWegdekZuid(6, "pm5001",90);
        x.insertWegdekZuid(7, "pm5002",100);
        x.insertWegdekZuid(8, "pm5003",110);
        x.insertWegdekZuid(9, "pm5004", 120);
        x.insertWegdekZuid(1, "pg1005",40);
        x.insertWegdekZuid(11, "pg1001",140);
        x.insertWegdekZuid(12, "pg1002",150);
        x.insertWegdekZuid(13, "pg1003",160);
        x.insertWegdekZuid(14, "pg0999",170);
        x.insertWegdekZuid(15,"pg0998", 180);
        x.insertWegdekZuid(5, "pg0997",80);
        x.insertWegdekZuid(17, "Brandweer",1);
        x.insertWegdekZuid(18, "pg0996",210);


        /*---------------------------------O O S T------------------------------------------*/


        x.insertWegdekOost(4, "pz8995", 250);
        x.insertWegdekOost(5, "pz8996", 260);
        x.insertWegdekOost(3,"pz8997",  240);
        x.insertWegdekOost(1, "pz8998", 220);
        x.insertWegdekOost(2,"pz9001",  230);

        /*--------------------------------W E S T--------------------------------------------*/

        x.insertWegdekWest(14,"pz9002",  400);
        x.insertWegdekWest(2, "pz9003", 280);
        x.insertWegdekWest(3, "pz9004", 290);
        x.insertWegdekWest(4, "pz9005", 300);
        x.insertWegdekWest(10,"pr4984",  360);
        x.insertWegdekWest(6,"pr8764",  320);
        x.insertWegdekWest(7, "pa4323", 330);
        x.insertWegdekWest(8, "pc5636", 340);
        x.insertWegdekWest(9,"Politie",  0);
        x.insertWegdekWest(5, "ps9463", 310);
        x.insertWegdekWest(11, "pf1324", 370);
        x.insertWegdekWest(12, "pm0974", 380);
        x.insertWegdekWest(13, "pq0124", 390);
        x.insertWegdekWest(1, "pg0669", 270);


        /*-----------------------------------R U N-------------------------------*/

                                            x.run();
                                            x.TreeSearch("pq0124");


    }
}























