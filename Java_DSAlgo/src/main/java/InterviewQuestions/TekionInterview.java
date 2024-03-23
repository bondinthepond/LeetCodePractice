package InterviewQuestions;

import java.util.*;

public class TekionInterview {


    String[] splitted = null;
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public ArrayList splitString(String input) {
        splitted = input.split("\\s+");

        ArrayList al = new ArrayList();
        for (int i = 0; i < splitted.length; i++) {
//            System.out.println(splitted[i]);
            al.add(splitted[i]);
        }
        return al;
    }


    public HashMap processList(ArrayList list) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < splitted.length; i++) {
            if (map.containsKey(splitted[i])) {
                int i1 = map.get(splitted[i]) + 1;
                map.put(splitted[i], i1);
            } else {
                map.put(splitted[i], 1);
            }
        }
        return map;
    }

    public void traverseMap(HashMap map) {
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }



    public void execute(String input){

        HashMap map = processList(splitString(input));
        traverseMap(map);

    }
}