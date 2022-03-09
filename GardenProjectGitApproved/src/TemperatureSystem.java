import java.util.ArrayList;
import java.util.Random;

public class TemperatureSystem {

    static Integer[][] testArray = new Integer[20][20];
    static Integer[] quadrantTemps = new Integer[4];

    //------------Instance Variables---------------//
    int quadrant;
    ArrayList<Integer> plants_in_prox = new ArrayList<>();

    TemperatureSystem(int quadrant){
        this.quadrant = quadrant;
    }

    public static void generateRandomTemp(){

        Random rand = new Random(); //instance of random class
        int upperbound = 25;
        for(int i=0;i<4;i++) {
            int int_random = rand.nextInt(40, 100);
            quadrantTemps[i] = int_random;
        }

    }

    public static void setQuadrantTemps(){}

    public void calculateOptimalTemperature(){}

    public void findPlantsInQuadrant(){}

    public void lowerTemp(){}

    public void raiseTemp(){}

    public static void main(String[] args) {

        TemperatureSystem test = new TemperatureSystem(1);


        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i < 10 && j < 10) {
                    System.out.print("1 ");
                }else if (i < 10 && j >= 10){
                    System.out.print("2 ");
                }else if (i >= 10 && j >= 10){
                    System.out.print("4 ");
                }else if (i >= 10 && j < 10){
                    System.out.print("3 ");
                } else {
                    System.out.print("= ");
                }
            }
            System.out.println();
        }


    }

}
