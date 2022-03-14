package plant;

public class Flower extends Plant {
  public Flower(int x, int y, String name) {
    // 3 water, 5 leaf, 15 tempHealth, 70-90 temp range, 15 days until harvest
    super(3, 5, 15, 70, 90, 15, x, y, name, "Flower");
  }

  // flower get waters, and water resets at 3 again
  public void water() {
    super.setWaterHealth(3);
  }

  // harvest to the flower and reset harvest day
  public void harvest() {
    super.setDayToHarvest(15);
  }

  public String toString() {
    return "F: " + super.toString();
  }
}
