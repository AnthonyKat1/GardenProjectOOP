import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Log {

    static int current_time_stamp;
    static Dictionary<String,Log> log_list;

    //------------------------https://www.baeldung.com/java-csv------------------------//
    public static String convertToCSV(String[] data) {
        return Arrays.stream(data).collect(Collectors.joining(","));
    }

    public static void addToLog(String log_name, String[] row_of_data){
        try (FileWriter fw = new FileWriter(log_name,true)) {
            //pw.println(convertToCSV(columns));
            fw.append(convertToCSV(row_of_data));
            fw.append("\n");
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createLog(String log_name, String[] columns){
        File csvOutputFile = new File(log_name);
        try (FileWriter pw = new FileWriter(csvOutputFile)) {
            //pw.println(convertToCSV(columns));

            pw.append("column_values->   "+convertToCSV(columns));
            pw.append("\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String[]> checkLog(String log_name,int column_to_check){

        ArrayList<String[]> DataRows = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(log_name));
            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {
                // Print the string
               // System.out.println(st);
                if (st.contains("column_values->")){continue;}
                try {
                    String[] row = st.split(",");
                    int columnValue = Integer.parseInt(row[column_to_check-1].toString());
                    if (1 == columnValue) {
                        DataRows.add(row);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return DataRows;

    }

    public static void main(String[] args){

        String[] PlantColumns =  {"plantInstance","time_stamp", "water_health","left_health", "tempHealth","days_to_harvest","Comment"};
        createLog("plantLog.csv",PlantColumns);

    /* Example on how to use
        createLog("plantLog.csv",columns);
        String[] row =  {"1", "6", "0","01"};
        String[] row2 =  {"1", "5", "0","02"};
        String[] row3 =  {"1", "3","1",  "03"};
        String[] row4 =  {"1", "4","0", "04"};
        String[] row5 =  {"1", "3","1", "05"};
        String[] row6 =  {"1", "5","0", "06"}; // Testing githu

        addToLog("plantLog.csv",row);
        addToLog("plantLog.csv",row2);
        addToLog("plantLog.csv",row3);
        addToLog("plantLog.csv",row4);
        addToLog("plantLog.csv",row5);
        addToLog("plantLog.csv",row6);
     */




    }
}
