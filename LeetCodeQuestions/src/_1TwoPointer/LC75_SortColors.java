package _1TwoPointer;

/*
Given an array, colors, which contains a combination of the following three elements:
0(representing red)
1(representing white)
2(representing blue)
Sort the array in place so that the elements of the same color are adjacent,
with the colors in the order of red, white, and blue.
To improve your problem-solving skills, do not utilize the built-in sort function.
*/

/*
Solution -
Take 3 pointers - start, current and end
start = 0, current = 0, end = end index
while (current <= end),
if nums[current] == 0, , and if nums[start] != 0, swap current and start. current++, start++
if nums[current] == 1, current++ - move the current pointer forward
if nums[current] == 2, and if nums[end] !=2 swap current and end. end--. If it is 0, then it will get processed by 2nd condition.
 */

import java.util.Arrays;

public class LC75_SortColors {
	public static int[] sortColors(int[] colors) {
		int start = 0;
		int current = 0;
		int end = colors.length - 1;

		while(current <= end){
				if(colors[current] == 0){
					if(colors[start] != 0){
						int temp = colors[start];
						colors[start] = colors[current];
						colors[current] = temp;
					}
					start++; //because start has a 0, either after going through the if block or not, move to next start
					current++; //if the current has non 0 value, if will get dealt with in next if blocks
				}
				 else if(colors[current] == 1){
					current++;
				} else { //colours[current] == 2
					 if(colors[end] != 2) {
						 int temp = colors[end];
						 colors[end] =  colors[current];
						 colors[current] = temp;
					 }
					 end--; //end has a 2, so move to previous end.
					        //no need to add another current++, it will be handled in the next iteration
				}
		}
		return colors;
	}

	// Driver code
	public static void main(String[] args) {
		int[][] inputs = {
				{0, 1, 0},
				{1, 1, 0, 2},
				{2, 1, 1, 0, 0},
				{2, 2, 2, 0, 1, 0},
				{2, 1, 1, 0, 1, 0, 2}
		};

		for (int i = 0; i < inputs.length; i++) {
			System.out.println((i + 1) + ".\tcolors: " + Arrays.toString(inputs[i]));

			int[] sortedColors = sortColors(inputs[i].clone());
			System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));

			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
}
