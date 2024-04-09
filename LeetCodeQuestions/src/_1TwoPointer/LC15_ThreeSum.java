package _1TwoPointer;

/*
Look at the class LC15_ThreeSum_Variant for problem description.
But in this version, display all possible triplets that match the target
 */

/*
1. Sort the array in ascending order
2. Store the first element of the array in i, and in the remaining array find two sum such that the sum = target - i;
3. To do 2 sum in the remaining part of the array, take 2 pointers, low and high.
4. low = i+1, high = last index
5. Now check if nums[i] + nums[low] + nums[high] = target, if yes, add them to result list
	5.1. Check other combinations for low and high - so low++ and high --
	5.2. However, check if there are repetitions.
	5.3. If there are repetition, skip untill there are no repetitions
6. If < target, low++.
7. If > target, high--;
8. Repeat on entire array. If still a combo of i, low and high is not found, return false.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		int low, high;
		List<List<Integer>> resultList = new ArrayList<>();

		for(int i=0; i<nums.length-2; i++){
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue; //skip current i, move on to next i, if there are repetition in i.
			}
			low = i+1;
			high = nums.length-1;

			while(low<high){

				int sum = nums[i] + nums[low] + nums[high];

				if(sum == 0){

					resultList.add(Arrays.asList(nums[i], nums[low], nums[high]));

					while (low < high && nums[low] == nums[low+1]){
						low++; //skip current low, move on to next low, if there are repetitions in low
					}
					while (low < high && nums[high] == nums[high-1]){
						high--; //skip current high, move on to next high, if there are repetitions in low
					}
					low++;
					high--;

				} else if (sum < 0){
					low++;
				} else {
					high --;
				}

			}
		}
		return resultList;
	}
}
