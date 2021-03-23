import item.Item;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private Map<Integer, Item> graphG;
    private Map<Integer, Item> sortedGraphG;
    private int indexG;
    private int indexSG;

    public Solution(List<Item> itemList){
        indexG = 0;
        indexSG = 0;
        for(Item item : itemList)
            graphG.put(indexG,item);

    }

/*    private Map<Item,Integer> SortMap(){
        return new TreeMap<Item,Integer>(new ValueComparator(graphG));
    }

    class ValueComparator implements Comparator<Integer> {
        Map<Integer, Item> base;

        public ValueComparator(Map<Integer, Item> base) {
            this.base = base;
        }

        public int compare(Integer a, Integer b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }*/
}
