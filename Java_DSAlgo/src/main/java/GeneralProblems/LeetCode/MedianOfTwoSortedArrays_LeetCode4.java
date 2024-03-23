package GeneralProblems.LeetCode;

public class MedianOfTwoSortedArrays_LeetCode4 {

    public double findMedianOfSortedArray(int[] nums1, int[] nums2) {

        int[] smaller, bigger;
        int totalLength = nums1.length + nums2.length;
        int half = totalLength / 2;

        if (nums1.length < nums2.length) {
            smaller = nums1;
            bigger = nums2;
        } else {
            smaller = nums2;
            bigger = nums1;
        }

        System.out.println("Smaller");
        printArray(smaller);

        System.out.println("Bigger");
        printArray(bigger);

        int left = -1;
        int right = smaller.length - 1;

        System.out.println("Old Left" + left);
        System.out.println("Old Right" + right);

        while (true) {

            int smaller_index = (left + right) / 2;
            System.out.println("Smaller_index " + smaller_index);
            int bigger_index = half - smaller_index - 2;
            System.out.println("Bigger_index " + bigger_index);

            int smaller_left, bigger_left, smaller_right, bigger_right;

            //pointers in the partitions - need to handle edge cases - if whole array is left partition of the combined array
            if(smaller_index >= 0) {
                smaller_left = smaller[smaller_index]; //right most element of left partition in the smaller array
            } else {
                smaller_left = -1000001;
            }

            if(smaller_index + 1 < smaller.length) {
                smaller_right = smaller[smaller_index + 1]; //left most element of the right partitions in the smaller array
            } else {
                smaller_right = 1000001;
            }

            if(bigger_index >= 0) {
                bigger_left = bigger[bigger_index]; //right most element of left partition in the smaller array
            } else {
                bigger_left = -1000001;
            }

            if(bigger_index + 1 < bigger.length) {
                bigger_right = bigger[bigger_index + 1]; //left most element of the right partition in the bigger array
            } else {
                bigger_right = 1000001;
            }

            System.out.println("smaller_left " + smaller_left + " smaller_right " + smaller_right  + " bigger_left " + bigger_left +
                    " bigger_right " + bigger_right);




            if (smaller_left <= bigger_right && bigger_left <= smaller_right) {
                if (totalLength % 2 != 0) {
                    return Math.min(smaller_right, bigger_right);
                } else {
                    return (Math.max(smaller_left, bigger_left) + Math.min(smaller_right, bigger_right)) / 2.0;
                }
            } else if (smaller_left > bigger_left) {
                right = smaller_index - 1;
                System.out.println("New Right " + right);
            } else {
                left = smaller_index + 1;
                System.out.println("New Left " + left);
            }
        }
    }

    public void printArray(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
