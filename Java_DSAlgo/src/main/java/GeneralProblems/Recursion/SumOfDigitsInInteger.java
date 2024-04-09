package GeneralProblems.Recursion;

public class SumOfDigitsInInteger {

    //Return sum of all the digits in an integer
    //f(n) = n%10 + f(n/10)

    public int sumOfDigits(int n){
        if(n <0){
            return -1;
        }
        if(n == 0){   //for numbers < 10, n/10 will become 0, i.e, the quotient
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }

    public void testSumOfDigits(){
        SumOfDigitsInInteger sumOfDigitsInInteger = new SumOfDigitsInInteger();
        System.out.println(sumOfDigitsInInteger.sumOfDigits(11234));
    }
}
