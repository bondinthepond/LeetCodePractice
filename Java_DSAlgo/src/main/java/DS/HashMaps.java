package DS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by aditya.mullela on 05/11/16.
 */
public class HashMaps {

    HashMap<Integer, String> testHashMap = new HashMap<Integer, String>();

    public void testHashMap(){
        testHashMap.put(1, "Aditya");
        testHashMap.put(2, "Tridisha");
        testHashMap.put(1, "mallela");

        Set entrySet = testHashMap.entrySet();

        System.out.println(entrySet);

        Set keySet = testHashMap.keySet();

        System.out.println(keySet);

        Iterator iterator = entrySet.iterator();

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println (entry.getKey());
            System.out.println (entry.getValue());
        }
    }
}
