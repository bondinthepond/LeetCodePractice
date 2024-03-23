package GeneralProblems.Recursion;

public class Palindrome {
    public boolean isPalindromeRecursively(String str){
        char first = str.charAt(0);
        char last = str.charAt(str.length()-1);

        boolean isPalindrome = true;

        if(first != last){
            isPalindrome = false;
        }

        int beginIndex = 1;
        int endIndex = str.length() - 2;

        if (beginIndex < endIndex){
            isPalindromeRecursively(str.substring(1, str.length()-2));
        } else if (beginIndex == endIndex) {
            isPalindromeRecursively(str.substring(beginIndex, beginIndex));
        }
        return isPalindrome;
    }



    public boolean isPalindromeRecursively2(String str){

        if(str.length() == 0 || str.length() == 1)
            return true;
        if(str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindromeRecursively2(str.substring(1, str.length()-1));
        }
        return false;
    }
}
