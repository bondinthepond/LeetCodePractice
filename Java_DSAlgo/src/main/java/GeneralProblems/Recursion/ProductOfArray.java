package GeneralProblems.Recursion;

public class ProductOfArray {

    public int findProductOfArray(int A[], int n){   //n = arr.length

        if(n == 1) return A[0] ;
        return A[n-1] * findProductOfArray(A, n-1);
    }
    //        int[] A = {1, 2,3, 4,5};
    //        System.out.println(p.findProductOfArray(A, A.length));
}
