import java.util.Arrays;

public class dayThread extends Thread{
        static int thread_day = 0; // Used to know what day it is
        static int day_in_seconds = 1; // used to simplify how long days are
        static int day = 1000*day_in_seconds; // used to simplified the caluclation of the wait for a day

    public void run() {

            while (thread_day<365) {
                //Start of Day
                thread_day +=1;
                Log.addToDailyLog("*** Rise and Shine: DAY "+thread_day+" ***");
                TemperatureSystem.generateRandomTemp();
                try
                {
                    Thread.sleep(day);
                }catch(InterruptedException e){System.out.println(e);}


                //-----------------------------------AT THE END OF THE DAY WE NEED TO------------------//
                // Increase harvest,harvest if possible
                // See if the plant is going to die or not
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (UserInterface.Plantgrid[i][j] != null){
                            //CHECK TEMP
                            if(!UserInterface.Plantgrid[i][j].isGoodtemperature()){
                                UserInterface.Plantgrid[i][j].decreaseTempHealth();

                            }

             //NEED TO DECRESE WATER AND HARVEST, NEED A CHECK FOR IF SOMETHING IS HARVESTABLE, IF IT IS, NEED TO RESET THE NUMBER
                            UserInterface.Plantgrid[i][j].oneDayPass();

                        }
                    }
                    }

                //End of day
                Log.addToDailyLog("*** THEY GO BY SO FAST: DAY "+thread_day+" IS OVER***");




            }
        }

        public static void main(String args[]) {




            //----------PLANTS----------//
            UserInterface.growFlower(0, 1, "blue flower");
            UserInterface.growTree(0, 2, "blue tree");
           // UserInterface.growBush(5, 1, "green bush");
            // UserInterface.growBush(5, 5, "green bush");



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


            //-------Logging System-----//

            //plantLog
            String[] PlantColumns = {"plantInstance", "time_stamp", "water_health", "left_health", "tempHealth", "days_to_harvest", "Comment"};
            Log.createCSVLog("plantLog.csv", PlantColumns);

            //sprinklerLog
            String[] SprinklerColumns = {"plantInstance", "time_stamp", "water_health", "left_health", "tempHealth", "days_to_harvest", "Comment"};
            Log.createCSVLog("sprinklerLog.csv", SprinklerColumns);

            //temperatureLog
            String[] TemperatureColumns = {"plantInstance", "time_stamp", "water_health", "left_health", "tempHealth", "days_to_harvest", "Comment"};
            Log.createCSVLog("temperatureLog.csv", TemperatureColumns);


            //dailyLog
            Log.createDailyLog("DailyLog.txt");


            dayThread dayThread = new dayThread();
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





