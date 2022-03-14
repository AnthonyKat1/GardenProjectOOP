public class Tree extends Plant {



    public Tree(int x, int y, String name) {
        // 10 water, 15 heath, 15 temp health, 50-100 range temp, 30 days until
        // harvest

        super(10, 15, 15, 50, 100, 30, x, y, name);
        this.maxWaterHealth = 10;

    }

    // flower get waters, and water resets at 8 again
    public void water() {
        super.setWaterHealth(10);
    }

    public String toString() {
        return "T: " + super.toString();
    }
}
