package GeneralProblems.LeetCode;

import java.util.HashSet;

public class ContainsDuplicate_LeetCode217 {

    public boolean checkDuplicate(int[] intArray) {
        boolean containsDuplicate = false;

        HashSet s = new HashSet();
        for (int i =0; i<intArray.length; i++){
            if(s.contains(intArray[i])){
                containsDuplicate = true;
            } else {
                s.add(intArray[i]);
            }
        }

        return containsDuplicate;
    }


    public boolean checkDuplicate2(int[] intArray) {
        boolean containsDuplicate = true;

        for (int i =0; i<intArray.length; i++){
            for(int j = i+1; j<intArray.length; j++){
                if(intArray[i] == intArray[j]){
                    containsDuplicate = false;
                }
            }
        }
        return containsDuplicate;
    }
}
