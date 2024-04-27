package collectors.algorithms;

public class ArrayOperations {

    public static void main(String[] args) {

        int[] arr={1,23,4,4,5,6,29};
        int max=arr[0];
        for( int j=0; j< arr.length ; j++)
        {
            if(arr[j]>max)
            max=arr[j];
        }
        System.out.println(max);

        int[] arr1={1,23,4,4,4,4,4,4,4,5,6,29};
        int i=0;
        for( int j=0; j< arr1.length; j++) {
            if (arr1[j] != arr1[i]) {
                i++;
                arr1[i] = arr1[j];
            }
        }
        System.out.println(i+1);




    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0; // Slow pointer
        for (int j = 1; j < nums.length; j++) { // Fast pointer
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Update nums[i] with the value of nums[j]
            }
        }

        // Length of the new array with duplicates removed
        return i + 1;
    }
}
