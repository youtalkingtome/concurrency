package collectors.algorithms;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr1={1,23,4,4,4,4,4,4,4,5,6,29};
        SelectionSort.selectionSort(arr1);
        System.out.println(SelectionSort.selectionSort(arr1));
        for( int i: SelectionSort.selectionSort(arr1))
        {
            System.out.println(i);
        }
    }

    static int findSmallest(int [] arr)
    {
        int smallest =arr[0];
        int smallest_index = 0;
        for( int j=0; j< arr.length ; j++)
        {
            if (arr[j]< smallest)
            {
                smallest=arr[j];
                smallest_index = j;
            }
        }
        return smallest_index;
    }

    public static int[] selectionSort(int[] arr)
    {
        int[] result= new int[arr.length];
        for( int j=0; j< arr.length ; j++) {
        int smallest=findSmallest(arr);
            result[j]=arr[smallest];
        }
        return result;
    }

}
