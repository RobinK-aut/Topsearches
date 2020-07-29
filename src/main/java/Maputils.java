import java.util.*;

public class Maputils {
    public List<Map.Entry<String, Integer>> GetTopXEntriesbyValue(HashMap<String, Integer> hmap, Integer top) {
        /**********************************************************************************************************
         * Description: Sortiert eine Hashmap nach Values und liefert die gewünschte Anzahl an Keysets als sublist *
         * Author: Robin Kirchner *
         **********************************************************************************************************/
        List<Map.Entry<String, Integer>> results = new ArrayList<Map.Entry<String, Integer>>(hmap.entrySet());
        Collections.sort(results, new Comperators());
        return results.subList(0, top);
    }

    public void PrintList(List<Map.Entry<String, Integer>> outList, String header) {
        /**********************************************************************************************************
         *  * Description: Ausgabe der Sublist in der Form Value x Key mit frei definierbarer Titelzeile          *
         *  * Author: Robin Kirchner                                                                              *
         *  *******************************************************************************************************/
        System.out.println(header);
        for (Object obj : outList) {
            String[] priline = obj.toString().split("=");
            System.out.println(priline[1] + "x \t" + priline[0]);
        }
    }


}


