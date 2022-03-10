public class dayThread extends Thread{
        static int thread_day = 0;
        public void run() {
            while (thread_day<365) {
                //Start of Day
                TemperatureSystem.generateRandomTemp();

                thread_day +=1;
                System.out.println("Day" + thread_day);
                try
                {
                    Thread.sleep(5000);
                }catch(InterruptedException e){System.out.println(e);}

                //End of day




            }
        }

        public static void main(String args[])
        {
            UserInterface.growFlower(0, 1, "blue flower");

            UserInterface.growTree(0, 2, "blue tree");

            UserInterface.growBush(2, 1, "blue bush");

            dayThread dayThread = new dayThread();

            tempThread tempSystem =new tempThread();

            tempThread quad2 =new tempThread();

            TemperatureSystem.generateRandomTemp();

            dayThread.start();

            tempSystem.start();


        }
    }
    class tempThread extends Thread {
        public void run() {
            TemperatureSystem.generateRandomTemp();


            TemperatureSystem Quad1 = new TemperatureSystem(1);
            System.out.println("Optimal Temp for quad " + Quad1.quadrant + " is " + Quad1.quadOptimalTemp);

            TemperatureSystem Quad2 = new TemperatureSystem(2);
            System.out.println("Optimal Temp for quad " + Quad2.quadrant + " is " + Quad2.quadOptimalTemp);

            while (dayThread.thread_day < 365) {
                for (TemperatureSystem S : TemperatureSystem.ActiveSystems) {
                    S.changeTemp(); // need to figrue out timing within the day

                }
                // need to add time delay


            }
        }


    }




