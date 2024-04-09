package GeneralProblems.LeetCode;

public class TwoSum_LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        int temp1 =0, temp2 = 0;
        for (int i = 0; i<nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    temp1 = i;
                    temp2 = j;
                    break;
                }
            }
        }
        int[] solution = new int[]{temp1, temp2};
        return solution;
    }


    // Method contents needs to be part of the main method, storing it here for reference
    public void testTwoSum(){
        TwoSum_LeetCode1 solution = new TwoSum_LeetCode1();

        int[] nums = {2, 5, 7, 8, 9};
        int target = 13;

        int[] solArr = solution.twoSum(nums, target);
        System.out.println(solArr[0] + "," +  solArr[1]);
    }
}
