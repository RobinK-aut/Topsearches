import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class topsearches {

    public static void main(String[] args) {
        // Variables
        String storeKey = "";
        String dataFile = ".//Logging.csv";

        //Object references
        Scanner input = new Scanner(System.in);
        CSVHandler csv = new CSVHandler();
        Maputils mapU = new Maputils();
        HashMap<String, Integer> ergebnis = new HashMap<String, Integer>();

        if (args.length > 0) {
            storeKey = args[0];
        } else {
            System.out.println("Bitte Storekey Eingeben");
            storeKey = input.nextLine();
        }

        ergebnis = csv.ReadNumberOfQueriesToHashmap(dataFile, storeKey);
        List<Map.Entry<String, Integer>> Sorted = mapU.GetTopXEntriesbyValue(ergebnis, 10);
        mapU.PrintList(Sorted, "Top 10 Searches:");
    }
}
