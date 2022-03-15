import java.util.ArrayList;

public class Bug {

  // each plant has 10% to be attacked
  // this method also handles if the plant dies or harvest
  public void attackPlant(Plant[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        // null means the spot is empty
        // not null means it is flower, tree, or bush
        Plant plant = grid[r][c];
        if (plant != null) {
          // Math.random() gives number from 0 - 1
          if (Math.random() < 0.1) { // 10% to be attacked
            plant.attack();
            // ADD A LOG
          }

          // check if the plant dies -> remove it
          if (!plant.isAlive()) {
            grid[r][c] = null;
          }
/*
          // handle harvest
          if (plant.canHarvest()) {
            if (plant.getType().contains("Bush")) {
              Bush b = (Bush) plant;
              b.harvest();
            } else if (plant.getType().contains("Flower")) {
              Flower f = (Flower) plant;
              f.harvest();
            } else {
              Tree t = (Tree) plant;
              t.harvest();
            }
          } */

        }
      }
    }

  }

}
