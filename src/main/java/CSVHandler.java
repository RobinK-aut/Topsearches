import java.util.*;
import java.io.*;


public class CSVHandler {

    public HashMap<String, Integer> ReadNumberOfQueriesToHashmap(String file, String storeKey) {
        /************************************************************************************
         * Description: Diese Funktion liest die CSV Datei zeilenweise ein,                 *
         *              maskiert Single Quotes 1/4 " anschliessend Fügt sie noch nicht      *
         *              in der Hashmap existierende Werte diese mit einem Value von 1 hinzu.*
         *              Bei vorhandenen Werten wird dieser Wert um 1 erhöht.                *
         *                                                                                  *
         * Author: Robin Kirchner                                                           *
         ************************************************************************************/
        String line = "";
        HashMap<String, Integer> queries = new HashMap<String, Integer>();
        try {
            BufferedReader csvIn = new BufferedReader(new FileReader(file));
            while ((line = csvIn.readLine()) != null) {
                if (line.startsWith(storeKey)) {
                    line.replace("\"", "\\\"");
                    String[] data = line.split("\t");
                    if (queries.containsKey(data[1])) {
                        Integer count = queries.get(data[1]) + 1;
                        queries.put(data[1], count);
                    } else {
                        queries.put(data[1], 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            String error = e.getMessage();
            System.out.println(error);
            System.exit(1);
        } catch (IOException e) {
            String error = e.getMessage();
            System.out.println(error);
            System.exit(1);
        }
        if (queries.size() == 0) {
            System.out.println("Für den angegebenen Shopkey wurden Keine Treffer Gefunden ");
            System.exit(0);
        }
        return queries;
    }

}