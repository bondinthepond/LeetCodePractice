package GeneralProblems.LeetCode;

import java.util.HashSet;

public class LongestSubstringWOrepeatingChar_LeetCode3 {

    public int lengthOfLongestSubstring(String s){
//        char[] chArr = s.toCharArray();

        HashSet set = new HashSet();

        int max = 0;
        int counter1 = 0;
        int counter2 = 0;

        while(counter1 < s.length()){
            if(!set.contains(s.charAt(counter1))){
                set.add(s.charAt(counter1));
                counter1++;
                max = Math.max(set.size(), max);
                System.out.println(set);
            } else {
                set.remove(s.charAt(counter2));
                counter2++;
                System.out.println(set);
            }
        }
        return max;
    }
}
