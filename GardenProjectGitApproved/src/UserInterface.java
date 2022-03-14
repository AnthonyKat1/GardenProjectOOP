import java.util.Arrays;

public class UserInterface {

  public static Plant[][] grid = new Plant[10][10];
  public static int numberOfFlower = 0;
  public static int numberOfTree = 0;
  public static int numberOfBush = 0;

  public static void main(String[] args) {
    growFlower(0, 1, "blue flower");
    growFlower(9, 5, "red flower");
    growFlower(8, 9, "white flower");
    growFlower(7, 6, "green flower");

    growTree(9, 8, "blue tree");
    growTree(5, 5, "red tree");
    growTree(7, 9, "white tree");
    growTree(6, 6, "green tree");

    growBush(8, 1, "blue bush");
    growBush(8, 5, "red bush");
    growBush(3, 9, "white bush");
    growBush(3, 6, "green bush");

    for (int i = 0; i < grid.length; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }

    for (int i = 0; i < 31; i++) {
      oneDayPass();
      Tree b = (Tree) grid[9][8];
      b.water();
      System.out.println();
      for (int j = 0; j < grid.length; j++) {
        System.out.println(Arrays.toString(grid[j]));
      }
    }
  }

  public static void growFlower(int x, int y, String name) {
    grid[x][y] = new Flower(x, y, name);
    numberOfFlower++;
  }

  public static void oneDayPass() {
    Bug bug = new Bug();
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] != null) { // this is a plant
          grid[r][c].oneDayPass();

          // attack the plant, clean the dead plant, reset harvest day if needed
          bug.attackPlant(grid);
        }
      }
    }
  }

  public static void growTree(int x, int y, String name) {
    grid[x][y] = new Tree(x, y, name);
    numberOfTree++;
  }

  public static void growBush(int x, int y, String name) {
    grid[x][y] = new Bush(x, y, name);
    numberOfBush++;
  }

  public static boolean isEmpty(int x, int y) {
    return grid[x][y] == null;
  }
}
