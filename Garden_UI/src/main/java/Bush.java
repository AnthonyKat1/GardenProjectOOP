public class Bush extends Plant {

    public Bush(int x, int y, String name) {
        // 8 water, 15 heath, 15 temp health, 60-80 temp range, 30 days until
        // harvest
        super(8, 15, 15, 60, 80, 30, x, y, name);
        this.maxWaterHealth = 8;

    }

    //flower get waters, and water resets at 6 again
    public void water() {
        super.setWaterHealth(8);
    }

    public String toString() {
        return "B: " + super.toString();
    }
}
