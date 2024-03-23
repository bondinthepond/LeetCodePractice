package GeneralProblems.Recursion;

public class DecimalToBinary {

    public int convertDecimalToBinary(int n){
        if (n==0) return 0;   // this means if n/2 = 0 or n < 2
        return n%2 + 10*convertDecimalToBinary(n/2);
    }
    // To test

//    DecimalToBinary convert = new DecimalToBinary();
//    System.out.println(convert.convertDecimalToBinary(13));
}
