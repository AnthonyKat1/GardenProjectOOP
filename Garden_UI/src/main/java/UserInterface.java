import java.util.Arrays;

public class UserInterface {

    public static Plant[][] Plantgrid = new Plant[10][10];
    public static int numberOfFlower = 0;
    public static int numberOfTree = 0;
    public static int numberOfBush = 0;

    public static void main(String[] args) {
        growFlower(0, 1, "blue flower");
        growFlower(2, 4, "red flower");   // CAN PLANT THINGS ON TOP OF EACH OTHER, NEED TO BE CAREFUL
        growFlower(2, 4, "white flower");
        growFlower(7, 6, "green flower");

        growTree(0, 2, "blue tree");
        growTree(5, 5, "red tree");
        growTree(7, 9, "white tree");
        growTree(6, 6, "green tree");

        growBush(2, 1, "blue bush");
        growBush(8, 5, "red bush");
        growBush(3, 9, "white bush");
        growBush(3, 6, "green bush");

        for (int i = 0; i < Plantgrid.length; i++) {
            System.out.println(Arrays.toString(Plantgrid[i]));
        }

        oneDayPass();
        System.out.println();
        for (int i = 0; i < Plantgrid.length; i++) {
            System.out.println(Arrays.toString(Plantgrid[i]));
        }

        System.out.println();
        System.out.println();
        Bush b = (Bush) Plantgrid[3][6];
        System.out.println(b);

        b.oneDayPass();
        b.oneDayPass();
        b.oneDayPass();
        System.out.println(b);
        b.attack();
        b.attack();
        System.out.println(b);
        b.tooCold();
        System.out.println(b);
        b.tooHot();
        System.out.println(b);
        b.water();
        System.out.println(b);


        TemperatureSystem QuadTest = new TemperatureSystem(1);
        System.out.println(QuadTest.quadOptimalTemp);
    }

    public static void growFlower(int x, int y, String name) {
        Plantgrid[x][y] = new Flower(x, y, name);
        numberOfFlower++;
    }

    public static void oneDayPass() {
        for (int r = 0; r < Plantgrid.length; r++) {
            for (int c = 0; c < Plantgrid[r].length; c++) {
                if (Plantgrid[r][c] != null) { // this is a plant
                    Plantgrid[r][c].oneDayPass();
                }
            }
        }
    }

    public static void growTree(int x, int y, String name) {
        Plantgrid[x][y] = new Tree(x, y, name);
        numberOfTree++;
    }

    public static void growBush(int x, int y, String name) {
        Plantgrid[x][y] = new Bush(x, y, name);
        numberOfBush++;
    }

    public static boolean isEmpty(int x, int y) {
        return Plantgrid[x][y] == null;
    }
}
