import java.util.ArrayList;
import java.util.Arrays;

public class Sprinkler {
    static Integer[][] testArray = new Integer[10][10];

    ArrayList<Plant> plants_in_promixity = new ArrayList<Plant>();
    int radius;
    Integer[] position_array = new Integer[2]; // [x, y] [4,6] // ------------NEED TO ADD POSITION
    ArrayList<Integer[]> radius_array = new ArrayList<>(); // [[x,y] [x,y]]

    Sprinkler(int x, int y) {
        position_array[0] = x;
        position_array[1] = y;
    }

    public void checkToWaterPlants() {
    }

    public void waterPlant() {
    }

    public void buildRadiusArray(int locX, int locY) {
        //https://stackoverflow.com/questions/8275795/algorithm-for-operating-on-2d-array-with-radius/8275819

        for (int x = locX - radius; x <= locX + radius; x++) {
            if (x > 5 || x < 0) {
                continue;
            }
            for (int y = locY - radius; y <= locY + radius; y++) {
                if (y > 5 || y < 0) {
                    continue;
                }
                Integer[] coordinates = new Integer[2];
                coordinates[0] = x;
                coordinates[1] = y;
                radius_array.add(coordinates);
            }
        }


    }

    public void addSprinklerRadiusToArray() {
        for (Integer[] integers : this.radius_array) {
            int x = integers[0];
            int y = integers[1];
            testArray[x][y] = 2;
        }
    }

    public void checkForPlantsInProximity(Plant[][] Plantgrid) {

       for (int i = 0; i < Plantgrid.length; i++) {
            System.out.println(Arrays.toString(Plantgrid[i]));
        }

            // Iterate over plant array
        for (Integer[] C: radius_array) {
            if (Plantgrid[C[0]][C[1]] != null) {
                plants_in_promixity.add(Plantgrid[C[0]][C[1]]);

            }
        }
    }

    public void checkPlants() {
    }

    public void waterPlants() {
    }

    public static void main(String[] args) {

        System.out.println("Small test");
        Sprinkler smallTest = new SmallSprinkler(1, 1);
        smallTest.addSprinklerRadiusToArray();
        System.out.println(smallTest.position_array[0] + " " + smallTest.position_array[1]);




        //print board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (testArray[i][j] == null) {
                    System.out.print("= ");
                } else {
                    System.out.print(testArray[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


}


class SmallSprinkler extends Sprinkler {
    SmallSprinkler(int x, int y) {
        super(x, y);
        this.radius = 1;
        buildRadiusArray(x, y);

    }
}
/*
class LargeSprinkler extends Sprinkler {
    LargeSprinkler(int x, int y) {
        super(x, y);
        this.radius = 2;
        buildRadiusArray(x, y);

    }
} */

/*   //----------Dont need a large sprinker, board is too small
class LargeSprinkler extends Sprinkler{
    LargeSprinkler(int x, int y){
        super(x,y);
        this.radius = 3;
        buildRadiusArray(x,y);

    } */


