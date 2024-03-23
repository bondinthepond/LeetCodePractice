package GeneralProblems.Arrays;

import java.util.HashMap;

public class AllPairWithGivenSum {

    //clarify requirements for this one - very confusing what the expected output should be
    public void printAllPairsWithGivenSum(int[] inputArr, int sum){

        HashMap<Integer, Integer> map = new HashMap();
        for (int i=0; i < inputArr.length; i++){
            if(map.containsKey(inputArr[i])){
                int count = map.get(inputArr[i]);
                count++;
                map.put(inputArr[i], count);
            } else {
                map.put(inputArr[i], 1);
            }
        }


        for(int i=0; i<inputArr.length;i++){
            int balance = sum - inputArr[i];
            if(map.isEmpty()) {
                System.out.println(" ");
            } else if(inputArr[i] == balance){
                int count = map.get(balance);
                for(int j =0; j<count-1; j++)  System.out.println(inputArr[i] + " " + balance);
                map.remove(balance);
            } else if(map.containsKey(  balance)) {
                int count = map.get(balance);
                for(int j =0; j<count; j++)  System.out.println(inputArr[i] + " " + balance);
                map.remove(balance);
                map.remove(inputArr[i]);
            }
        }
    }
}
