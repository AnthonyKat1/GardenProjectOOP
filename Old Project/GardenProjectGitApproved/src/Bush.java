public class Bush extends Plant {

  public Bush(int x, int y, String name) {
    // 4 water, 15 heath, 15 temp health, 60-80 temp range, 30 days until
    // harvest
    super(4, 15, 15, 60, 80, 30, x, y, name, "Bush");
  }

//bush get waters, and water resets at 5 again
  public void water() {
    super.setWaterHealth(4);
  }

//harvest to the bush and reset harvest day
  public void harvest() {
    super.setDayToHarvest(30);
  }

  public String toString() {
    return "B: " + super.toString();
  }
}
