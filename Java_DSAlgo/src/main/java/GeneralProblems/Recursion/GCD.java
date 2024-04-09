package GeneralProblems.Recursion;

public class GCD {
        public int findGCD(int a, int b){
            if(a<0 || b<0) return -1;
            if(b == 0) return a;
            return findGCD(b, a%b);
        }

    public void testGCD(){
            GCD gcd = new GCD();
            System.out.println(gcd.findGCD(10, 20));
    }
}
