package GeneralProblems.Recursion;

import java.util.Arrays;

public class someRecursive {

    public boolean someRecursive(int[] arr, OddFunction odd) {
        odd = new OddFunction();
        if (arr.length == 0) {
            return false;
        } else if (odd.run(arr[0])) {
            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
        } else {
            return false;
        }
    }
}



