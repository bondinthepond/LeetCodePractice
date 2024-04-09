package _1TwoPointer;

/*
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum is equal to the target, that is,
nums[i] + nums[j] + nums[k] == target. Return TRUE if three such integers exist in the array.
Otherwise, return FALSE.
*/

/*
1. Sort the array in ascending order
2. Store the first element of the array in i, and in the remaining array find two sum such that the sum = target - i;
3. To do 2 sum in the remaining part of the array, take 2 pointers, low and high.
4. low = i+1, high = last index
5. Now check if nums[i] + nums[low] + nums[high] = target, if yes, return true
6. If < target, low++.
7. If > target, high--;
8. Repeat on entire array. If still a combo of i, low and high is not found, return false.
*/

// Time Complexity - for Sorting - n log n, for the 2 loops - n^2
// Sapce complexity - for sorting log n

import java.util.Arrays;

public class LC15_ThreeSum_Variant {
		public static boolean findSumOfThree(int nums[], int target) {

			Arrays.sort(nums);
			int low, high, sum;

			for (int i = 0; i < nums.length - 2; i++) {
				low = i + 1;
				high = nums.length - 1;

				while (low < high) {
					sum = nums[i] + nums[low] + nums[high];

					if (sum == target) {
						return true;
					}
					else if (sum < target) {
						low++;
					}
					else {
						high--;
					}
				}
			}

			return false;
		}

		// Driver code
		public static void main(String[] args) {
			int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
					{-1, 2, 1, -4, 5, -3},
					{2, 3, 4, 1, 7, 9},
					{1, -1, 0},
					{2, 4, 2, 7, 6, 3, 1}};

			int[] testList = {10, 7, 20, -1, 8};


			for (int i=0; i<testList.length; i++) {
				System.out.print(i+1);
				System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

				if (findSumOfThree(numsList[i], testList[i])) {
					System.out.println("\tSum for " + testList[i] + " exists ");
				} else {
					System.out.println("\tSum for " + testList[i] + " does not exist ");
				}

				System.out.println(new String(new char[100]).replace('\0', '-'));
			}
		}
	}
