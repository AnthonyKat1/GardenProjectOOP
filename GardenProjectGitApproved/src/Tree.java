package plant;

public class Tree extends Plant {

  public Tree(int x, int y, String name) {
    // 5 water, 15 heath, 15 temp health, 50-100 range temp, 30 days until
    // harvest
    super(5, 15, 15, 50, 100, 30, x, y, name, "Tree");
  }

  // tree get waters, and water resets at 5 again
  public void water() {
    super.setWaterHealth(5);
  }

  // harvest to the tree and reset harvest day
  public void harvest() {
    super.setDayToHarvest(30);
  }

  public String toString() {
    return "T: " + super.toString();
  }
}
