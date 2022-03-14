public class Flower extends Plant {
    public Flower(int x, int y, String name) {
        // 7 water, 5 leaf, 15 tempHealth, 70-90 temp range, 15 days until harvest
        super(7, 5, 15, 70, 90, 15, x, y, name);
        this.maxWaterHealth = 7;

    }

    // flower get waters, and water resets at 5 again
    public void water() {
        super.setWaterHealth(7);
    }

    public String toString() {
        return "F: " + super.toString();
    }
}
