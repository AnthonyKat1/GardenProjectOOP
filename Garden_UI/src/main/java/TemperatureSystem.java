import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TemperatureSystem {

    static TemperatureSystem[][] TempArray = new TemperatureSystem[10][10];
    static Integer[] quadrantTemps = new Integer[4];

    //------------Instance Variables---------------//
    int quadrant;
    Integer[] position = new Integer[2]; // x,y
    ArrayList<Plant> plants_in_prox = new ArrayList<Plant>();
    int quadOptimalTemp;
    int Symbol = 4;

    TemperatureSystem(int quadrant) {

        this.quadrant = quadrant;
        this.setSystemOnGrid();
        this.findPlantsInQuadrant(UserInterface.Plantgrid);
        this.calculateOptimalTemperature();
    }


    private void setSystemOnGrid() {
        switch (quadrant) {
            case 1:
                this.position[0] = 0;
                this.position[1] = 0;
                break;
            case 2:
                this.position[0] = 9;
                this.position[1] = 0;
                break;
            case 3:
                this.position[0] = 0;
                this.position[1] = 9;
                break;
            case 4:
                this.position[0] = 9;
                this.position[1] = 9;
                break;
        }
        TempArray[this.position[0]][this.position[1]] = this;
    }

    //@@Get random temp, NEED TO GET A DAY FUNTION TO TRIGGER IT
    private static void generateRandomTemp() {

        Random rand = new Random(); //instance of random class
        int upperbound = 25;
        for (int i = 0; i < 4; i++) {
            int int_random = rand.nextInt(40, 100);
            quadrantTemps[i] = int_random;
        }

    }

    //@@USING PLANTS IN QUADRANT TO CALCULATE OPTIMAL TEMP
    private void calculateOptimalTemperature() {
        int count = 0;
        int total = 0;
        for (Plant p : plants_in_prox) {
            total += (p.getMaxTemperature() + p.getMinTemperature()) / 2;
            count += 1;

        }
        quadOptimalTemp = total / count;

    }

    //@@FINDS PLANTS AND ADDS THEM TO ARRAY
    private void findPlantsInQuadrant(Plant[][] Plantgrid) {

        for (int i = 0; i < Plantgrid.length; i++) {
            System.out.println(Arrays.toString(Plantgrid[i]));
        }

        // Iterate over plant array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                // If plant isnt null
                if (Plantgrid[i][j] != null) {

                    // if plant is within quadrant 1 and the plant is quadrant 1
                    if (i < 5 && j < 5) {
                        if (quadrant == 1) {
                            plants_in_prox.add(Plantgrid[i][j]);
                        }
                        System.out.print("1 "); // Quadrant 1
                    } else if (i < 5 && j >= 5) {
                        System.out.print("2 "); // Quad 2
                    } else if (i >= 5 && j >= 5) {
                        System.out.print("4 "); // Quad 4
                    } else if (i >= 5 && j < 5) {
                        System.out.print("3 "); // Quad 3
                    } else {
                        System.out.print("= ");
                    }
                }
            }
            System.out.println();
        }


        System.out.println(plants_in_prox);
    }

    //@@PRINTS TEMP ARRAY, FOR TESTING
    private static void printTempArray() {
        //print board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (TempArray[i][j] == null) {
                    System.out.print("= ");
                } else {
                    System.out.print(TempArray[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    // AFTER OBTAINS PLANT ARRAY, ITERATES OVER THEM TO SET TEMP FOR EACH
    public static void setQuadrantTemps() {
    }

    //MIGHT BE ABLE TO COMBINE THESE TWO, WILL NEED TO ITERATE OVER THE PLANTS TO CHANGE TEMP WITH SOME SORT OF TIME DELAY
    public void lowerTemp() {
    }

    public void raiseTemp() {
    }


    public static void main(String[] args) {

        TemperatureSystem Quad1 = new TemperatureSystem(1);

        TemperatureSystem Quad2 = new TemperatureSystem(2);
        TemperatureSystem Quad3 = new TemperatureSystem(3);
        TemperatureSystem Quad4 = new TemperatureSystem(4);

        printTempArray();


    }


}


