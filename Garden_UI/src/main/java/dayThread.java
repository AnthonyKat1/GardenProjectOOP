import java.util.Arrays;

public class dayThread extends Thread{
        static int thread_day = 0;
        static int day_in_seconds = 1;
        static int day = 1000*day_in_seconds;

    public void run() {

            while (thread_day<365) {
                //Start of Day
                TemperatureSystem.generateRandomTemp();

                thread_day +=1;
                System.out.println("Day" + thread_day);
                try
                {
                    Thread.sleep(day);
                }catch(InterruptedException e){System.out.println(e);}


                // AT THE END OF THE DAY WE NEED TO
                // Increase harvest,harvest if possible Decrease water by one, Check if temperature is within range
                // See if the plant is going to die or not
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (UserInterface.Plantgrid[i][j] != null){

                            //CHECK TEMP
                            if(!UserInterface.Plantgrid[i][j].isGoodtemperature()){
                                UserInterface.Plantgrid[i][j].decreaseTempHealth();

                            }

                            //DECREASE WATER
                            UserInterface.Plantgrid[i][j].decreaseWaterHealth();

                        }
                    }
                    }

                //End of day




            }
        }

        public static void main(String args[])
        {
            //----------PLANTS----------//
            UserInterface.growFlower(0, 1, "blue flower");
            UserInterface.growTree(0, 2, "blue tree");
           // UserInterface.growBush(5, 1, "green bush");
            //UserInterface.growBush(5, 5, "green bush");
            //------SPRINKLERS-----//

            Sprinkler Sprinkler1 = new Sprinkler(1,2);
            SprinklerThread Sprink1 = new SprinklerThread();
            Sprink1.start();



            //------TEMPERATURE SYSTEM-----//
            TemperatureSystem.generateRandomTemp();
            TemperatureSystem Quad1 = new TemperatureSystem(1);
            TemperatureSystem Quad2 = new TemperatureSystem(2);
            TemperatureSystem Quad3 = new TemperatureSystem(3);
            TemperatureSystem Quad4 = new TemperatureSystem(4);
            tempThread tempSystem =new tempThread();
            tempSystem.start();

            dayThread dayThread = new dayThread();


            for (int i = 0; i < UserInterface.Plantgrid.length; i++) {
                System.out.println(Arrays.toString(UserInterface.Plantgrid[i]));
            }

            dayThread.start();



        }
    }
    class tempThread extends Thread {
        public void run() {

            while (dayThread.thread_day < 365) {
                for (TemperatureSystem T : TemperatureSystem.ActiveSystems) {
                    T.changeTemp();

                }
                try {
                    Thread.sleep(dayThread.day/5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }


    }

class SprinklerThread extends Thread {
    public void run() {

        while (dayThread.thread_day < 365) {
            for (Sprinkler S : Sprinkler.sprinkler_array) {
                S.checkToWaterPlants();

            }

        }
    }

}





