package GeneralProblems.Arrays;

public class SortByParity {

    //Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
    public int[] sortArrayByParity(int[] nums) {
        int pointer1 = 0;
        int odd_pointer = 0;

        while(pointer1 < nums.length){
            if(nums[pointer1]% 2 == 0){
                pointer1++;
                odd_pointer++;

            } else {

                int temp = nums[pointer1];
                nums[pointer1] = nums[odd_pointer];
                nums[odd_pointer] = temp;

                odd_pointer++;
            }
        }
        return nums;
    }
}
