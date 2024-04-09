package GeneralProblems.LeetCode;

import java.util.*;

public class ContainsDuplicate2_LeetCode219 {
//    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that
//    nums[i] == nums[j] and abs(i - j) <= k.


//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k) {
//        boolean containsRequired = false;
//
//        for(int i=0; i<nums.length; i++){
//            for(int j=1; j<nums.length; j++){
////                if(Math.abs(nums[i] - nums[j]) <=t && Math.abs(i - j) <=k && i != j){
////                    containsRequired = true;
////                }
//                if(nums[i] == nums[j] && Math.abs(i - j) <=k && i != j ){
//                    containsRequired = true;
//                }
//            }
//        }
//        return containsRequired;
//    }
//}


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k) {
        boolean containsRequired = false;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            }
        }

        Set<Map.Entry<Integer, ArrayList<Integer>>> entrySet = map.entrySet();

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();

            ArrayList<Integer> temp = entry.getValue();

            System.out.println("key " + entry.getKey() + " Value " + temp);

            if (temp.size() > 1) {
                for(int i = 0; i<temp.size()-1; i++){
                        if(Math.abs(temp.get(i) - temp.get(i+1)) <= k){
                            containsRequired = true;
                        }
                    }
                }
            }
        return containsRequired;
    }
}