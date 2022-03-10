public class Plant {
// 3 childrent: Flower, Tree, and Bush
  // Grid: 2D Array of Plant
  private int waterHealth;
  private int leafHealth;
  private int tempHealth;
  private int[] tempRange = new int[2];
  private int dayToHarvest;
  private int[] tracker = new int[2];
  private String name;

  public Plant(int w, int l, int t, int minT, int maxT, int d, int x, int y,
      String n) {
    waterHealth = w;
    leafHealth = l;
    tempHealth = t;
    tempRange[0] = minT;
    tempRange[1] = maxT;
    dayToHarvest = d;
    tracker[0] = x;
    tracker[1] = y;
    name = n;
  }

  public int getWaterHealth() {
    return waterHealth;
  }

  public int getLeafHealth() {
    return leafHealth;
  }

  public int getTempHealth() {
    return tempHealth;
  }

  public int getDayToHarvest() {
    return dayToHarvest;
  }

  public String getName() {
    return name;
  }

  public int[] getTracker() {
    return tracker;
  }

  public int getMinTemperature() {
    return tempRange[0];
  }

  public int getMaxTemperature() {
    return tempRange[1];
  }

  public void setWaterHealth(int value) {
    waterHealth = value;
  }

  public void setLeafHealth(int value) {
    leafHealth = value;
  }

  public void setTempHealth(int value) {
    tempHealth = value;
  }

  public void setDayToHarvest(int value) {
    dayToHarvest = value;
  }

  public void setName(String value) {
    name = value;
  }

  public boolean isAlive() {
    return leafHealth > 0 && waterHealth > 0 && tempHealth > 0;
  }

  public boolean canHarvest() {
    return dayToHarvest <= 0;
  }

  public boolean isGoodtemperature(int temp) {
    return tempRange[0] <= temp && temp <= tempRange[1];
  }

  public void oneDayPass() { //--------------Maybe instead of just implemplenting this at an instance level it could
    waterHealth--;        //--------------loop through all of the plants in a static form
    dayToHarvest--;
  }

  public void attack() {
    leafHealth--;
  }

  public void tooHot() {
    tempHealth--;
  }

  public void tooCold() {
    tempHealth--;
  }

  public String toString() {
    return name + ", waterHealth: " + waterHealth + ", leafHealth: "
        + leafHealth + ", tempHealth:" + tempHealth
        + ", dayToHarvest: " + dayToHarvest;
  }
}
