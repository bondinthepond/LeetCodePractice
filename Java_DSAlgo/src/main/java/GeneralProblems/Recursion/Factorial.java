package GeneralProblems.Recursion;

public class Factorial {

    public int factorial(int n){
        if(n < 0){
            return -1;
        }
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    // Method contents needs to be part of the main method, storing it here for reference
    public void testFactorial(){
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(10));
        System.out.println(factorial.factorial(0));
        System.out.println(factorial.factorial(-1));
    }
}
