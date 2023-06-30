import java.util.HashMap;
import java.util.Map;

public class LC1_TwoSum {

	//Given an array of integers nums and an integer target,
	// return indices of the two numbers such that they add up to target.
	//You may assume that each input would have exactly one solution, and you may not use the same element twice.

	public static void main(String[] args){
		int[] nums = new int[10];  //Size of array, once instantiated, is fixed
		nums[0] = 2;
		nums[1] = 7;
		nums[2] = 11;
		nums[3] = 15;
		nums[4] = 21;

		int[] nums1 = {2, 7, 11, 15, 21};

		int target = 23;
		int[] solution = twoSumIndicies_Approach1(nums, target);
		System.out.println("Solution " + solution[0] + " , " + solution[1]);
	}

	public static int[] twoSumIndicies_Approach1(int[] nums, int target){
		//Brute Force Appraoch

		//Time complexity - O(n^2)
		//Space complexity - O(1)
		int temp1 = 0; int temp2 = 0;
		for (int i=0; i<nums.length; i++){
			for(int j = i+1; j< nums.length; j++){
				if (nums[i] + nums[j] == target) {
					temp1 = i;
					temp2 = j;
					break;
				}
			}
		}
		int[] solution = {temp1, temp2};
		return solution;
	}

	public static int[] twoSumIndicies_Approach2(int[] nums, int target) {

		//Using HashMap

		//Put all number in a map.
		//Look up in map can be done in O(1), while look up in Arrays is O(n)
		//Once all element are in a map - search for the complement in the map.

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[]{i, map.get(complement)};
			}
		}
		return null;

		// Time complexity - O(n)
		// Space Complexity - O(n)
	}

	public static int[] twoSumIndicies_Approach3(int[] nums, int target){

		//Using Maps

		//Look  for the difference in a map
		//Don't add all elements to map by default
		//Add elements to map, if complement does not exist in the map, untill it exists.
		Map<Integer, Integer> mapOfNumbersAlreadyVisited = new HashMap<>();
		for(int i =0; i < nums.length; i++){
			int current = nums[i];
			int x = target - current;
			if (mapOfNumbersAlreadyVisited.containsKey(x)) {
				return new int[]{mapOfNumbersAlreadyVisited.get(x), i};
			}
			mapOfNumbersAlreadyVisited.put(current, i);
			}
		return null;
		}

		// Time complexity - O(n)
		// Space Complexity - O(n) - space is not used, unless the matching complement is found in the last iteration

	}
