import java.util.Comparator;
import java.util.Map;

public class Comperators implements Comparator<Map.Entry<String, Integer>> {
    //** Vergleich für absteigende Reihenfolge. **

    @Override
    public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
        /*****************************************************************************
         * Comperator für Sortierung der Map *
         *****************************************************************************/
        if (obj1.getValue() < obj2.getValue()) {
            return 1;
        } else if (obj1.getValue() > obj2.getValue()) {
            return -1;
        }
        return 0;
    }
}
