package GeneralProblems.Recursion;

public class RecursiveRange {


    //not sure of the problem statement

    public int recursiveRange(int num){

        if(num < 0) return -1;
        if(num ==1 || num == 0 ){
            return num;
        }
        return num + recursiveRange(num-1);
    }

    public int iterativeRange(int num){
        int sum = 0;
        for (int i=0; i <= num; i++){
            sum = sum + i;
        }
        return sum;
    }
}
