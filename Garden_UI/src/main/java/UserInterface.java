import java.util.Arrays;

public class UserInterface {
    //Used for user interactions
    public static Plant[][] Plantgrid = new Plant[6][6];
    public static int numberOfFlower = 0;
    public static int numberOfTree = 0;
    public static int numberOfBush = 0;
    static int day;
    static int Second = 1000;

    //Used for testing
    public static void main(String[] args) {

        growFlower(0, 1, "blue flower");
        growFlower(2, 3, "red flower");   // CAN PLANT THINGS ON TOP OF EACH OTHER, NEED TO BE CAREFUL
        growFlower(2, 4, "white flower");
        Sprinkler test = new Sprinkler(1,1);
/*
        growTree(0, 2, "blue tree");
        growTree(5, 5, "red tree");

        growBush(2, 1, "blue bush");
        growBush(3, 2, "white bush");

        TemperatureSystem QuadTest = new TemperatureSystem(1);
        QuadTest.setQuadrantTemps(); //Daily Set of new temperature

        for (int i = 0; i < Plantgrid.length; i++) {
            System.out.println(Arrays.toString(Plantgrid[i]));
        }
        QuadTest.setQuadrantTemps();
        oneDayPass();
        System.out.println();
        */
        for (int i = 0; i < Plantgrid.length; i++) {
            System.out.println(Arrays.toString(Plantgrid[i]));
        }


    }

    // Used to help when creating buttons
    public static void growFlower(int x, int y, String name) {
        Plantgrid[x][y] = new Flower(x, y, name);
        numberOfFlower++;
    }

    // Used to help when creating buttons
    public static void growTree(int x, int y, String name) {
        Plantgrid[x][y] = new Tree(x, y, name);
        numberOfTree++;
    }

    // Used to help when creating buttons
    public static void growBush(int x, int y, String name) {
        Plantgrid[x][y] = new Bush(x, y, name);
        numberOfBush++;
    }

    public static boolean isEmpty(int x, int y) {
        return Plantgrid[x][y] == null;
    }
}
