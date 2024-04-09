package InterviewQuestions;

public class LennaAIInterview {


//    2 questions -
//
//    leetcode 974
//    https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

//    public void arrangeStuff(int[] arr, boolean type){
//
//        int counter_0 = 0;
//        int counter_1 = 0;
//        for(int i = 0; i<arr.length;i++){
//            if(arr[i] == 0){
//                counter_0++;
//            } else if(arr[i] == 1){
//                counter_1++;
//            }
//        }
//
//
//        if (type == true){
//            int i = 0;
//            while(counter_1 != 0){
//                arr[counter_1] = 0;
//
//            } else if(type == false){
//        if(counter_0 == counter_1){
//            for(int i = 0; i<arr.length; i++){
//            if(i%2 ==0){
//                arr[i] = 0;
//            } else {
//                arr[i] = 1;
//            }
//        }
//        printArray(arr);
//        } else {
//            for(int i = 0; i<)
//        }
//    }
//
//
//    public void analyzeIpnut(int[] nums){
//        boolean type1 = true;
//        boolean type2 = true;
//        if(
//            for(int i = 0; i< nums.length; i++){
//                if(nums[i] == 0 && i%2 == 0){
//
//                }
//            )
//        }
//    }
//    public void printArray(int[] nums){
//        for (int i = 0; i <nums.length ; i++) {
//            System.out.println(nums[i]);
//        }
//    }
//
//    public void longestSubArray(int[] nums, int x){
//
//        int sum = 0;
//        int[] solution;
//        int pointer = 0;
//
//        int sol_index=0;
//        for(int i=0; i< nums.length; i++){
//            sum += nums[i];
//
//            if(sum % x ==0){
//                if(i > sol_index) sol_index = i;
//            }
//        }
//
//        int front_pointer = 0;
//        if(sum % x != 0) {
//            for (int i = 0; i < nums.length; i++) {
//                sum = sum - nums[i];
//                if(sum %x ==0){
//                    front_pointer = i;
//                }
//            }
//        }
//        array(front_pointer, sol_index);
//    }
}
