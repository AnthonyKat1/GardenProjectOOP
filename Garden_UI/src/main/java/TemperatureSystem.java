import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TemperatureSystem {

    static TemperatureSystem[][] TempArray = new TemperatureSystem[6][6];
    static Integer[] quadrantTemps = new Integer[5];
    static ArrayList<TemperatureSystem> ActiveSystems = new ArrayList<TemperatureSystem>();
    //------------Instance Variables---------------//
    int quadrant;
    Integer[] position = new Integer[2]; // x,y
    ArrayList<Plant> plants_in_prox = new ArrayList<Plant>();
    int quadOptimalTemp;
    int current_temp;

    TemperatureSystem(int quadrant) {
        this.quadrant = quadrant;
        this.setSystemOnGrid();
        this.findPlantsInQuadrant(UserInterface.Plantgrid);
        if (!this.plants_in_prox.isEmpty()){
        this.calculateOptimalTemperature();

        ActiveSystems.add(this);
        }

    }


    private void setSystemOnGrid() {
        switch (quadrant) {
            case 1:
                this.position[0] = 0;
                this.position[1] = 0;
                break;
            case 2:
                this.position[0] = 5;
                this.position[1] = 0;
                break;
            case 3:
                this.position[0] = 0;
                this.position[1] = 5;
                break;
            case 4:
                this.position[0] = 5;
                this.position[1] = 5;
                break;
        }
        TempArray[this.position[0]][this.position[1]] = this;
    }

    //@@Get random temp, NEED TO GET A DAY FUNTION TO TRIGGER IT
     static void generateRandomTemp() {

        Random rand = new Random(); //instance of random class
        for (int i = 0; i < 5; i++) {
            int int_random = rand.nextInt(40, 100);
            quadrantTemps[i] = int_random;

        }

         for (TemperatureSystem TS: ActiveSystems) {
           //  System.out.println(TS.quadrant + " New temp is "+ quadrantTemps[TS.quadrant]);
             TS.setPlantTemps();
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

       /* for (int i = 0; i < Plantgrid.length; i++) {
            System.out.println(Arrays.toString(Plantgrid[i]));
        } */

        // Iterate over plant array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

                // If plant isnt null
                if (Plantgrid[i][j] != null) {

                    // if plant is within quadrant 1 and the plant is quadrant 1
                    if (i < 3 && j < 3 && quadrant == 1) {
                            plants_in_prox.add(Plantgrid[i][j]);

                    } else if (i < 3 && j >= 3 && quadrant == 2) {
                            plants_in_prox.add(Plantgrid[i][j]);

                    } else if (i >= 3 && j >= 3 && quadrant == 4) {
                            plants_in_prox.add(Plantgrid[i][j]);

                    } else if (i >= 3 && j < 3 && quadrant == 3) {
                            plants_in_prox.add(Plantgrid[i][j]);

                    }
                }
            }
        }

    }

    //@@PRINTS TEMP ARRAY, FOR TESTING
    private static void printTempArray() {
        //print board
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (TempArray[i][j] == null) {
                    System.out.print("= ");
                } else {
                    System.out.print(TempArray[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    // AFTER OBTAINS PLANT ARRAY, ITERATES OVER THEM TO SET INITAL TEMP FOR EACH
    public void setPlantTemps() {
        current_temp = quadrantTemps[quadrant];
        for (Plant P: plants_in_prox) {
            P.setCurrentTemp(current_temp);
        }
    }

    //MIGHT BE ABLE TO COMBINE THESE TWO, WILL NEED TO ITERATE OVER THE PLANTS TO CHANGE TEMP WITH SOME SORT OF TIME DELAY
    public void changeTemp() {
        if(current_temp==0){
        } else if (current_temp>quadOptimalTemp){
            current_temp -=1;
            //System.out.println(quadrant+" Lowering Temp to "+current_temp);
        } else if (current_temp<quadOptimalTemp) {
            current_temp += 1;
           // System.out.println(quadrant + " Raising Temp to " + current_temp);
        }

            for (Plant P: plants_in_prox) {
                P.setCurrentTemp(current_temp);
            }

    }





    public static void main(String[] args) {

        TemperatureSystem Quad1 = new TemperatureSystem(1);
        TemperatureSystem Quad2 = new TemperatureSystem(2);
        TemperatureSystem Quad3 = new TemperatureSystem(3);
        TemperatureSystem Quad4 = new TemperatureSystem(4);
        printTempArray();


    }


}


