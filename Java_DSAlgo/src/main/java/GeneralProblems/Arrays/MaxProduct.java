package GeneralProblems.Arrays;

public class MaxProduct {
    //Give an array of integers, find the max possible product


    //Find max and maxNext
    public void findMax(int[] intArr){

        int max = intArr[0];
        int maxNext = intArr[0];
        for(int i = 0; i<intArr.length; i++){
            if (intArr[i] > max) {
                maxNext = max;
                max = intArr[i];
            }
        }
        System.out.println("Max = " + max + " " + "MaxNext = " + maxNext);
    }


    public int findMaxProduct(int[] intArr){
        int max = intArr[0];
        int maxNext = intArr[0];
        for(int i = 0; i<intArr.length; i++){
            if (intArr[i] > max) {
                maxNext = max;
                max = intArr[i];
            }
        }
        return max*maxNext;
    }
}
