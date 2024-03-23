package GeneralProblems.Recursion;

public class Power {

    public int findPower(int base, int power){
        if (power < 0) return -1;
        if (power == 0) return 1;
        return base * findPower(base, power-1);
    }

    //Test

    //Power power = new Power();
    //System.out.println(power.findPower(-2, 0));
}
