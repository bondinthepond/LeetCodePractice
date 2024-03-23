package GeneralProblems.Recursion;

public class FibonacciSeries {
    public int giveFibonacciNumberAt(int n){
        if (n < 0){
            return -1;
        }

        if(n == 0){
            return 0;
        } else if(n == 1) {
            return 1;
        }
        return giveFibonacciNumberAt(n-1) + giveFibonacciNumberAt(n-2);
    }

    public void displayFibonacciSeriesUpto(int n){
        for (int i=0; i<n; i++){
            System.out.print("|" + giveFibonacciNumberAt(i));
        }
    }

    public void testFibonacciSeries(){
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        System.out.println(fibonacciSeries.giveFibonacciNumberAt(6));
        fibonacciSeries.displayFibonacciSeriesUpto(10);
    }
}
