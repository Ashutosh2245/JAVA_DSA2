package Arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int ans = remove(arr);
        System.out.println("Length of array after operation: "+ans);
        System.out.println("Array: "+ Arrays.toString(arr));
        System.out.println("Required array of length "+ans+": "+ Arrays.toString(Arrays.copyOf(arr, ans)));
    }
    public static int remove(int[] arr){
        int n = arr.length;
        if(n <= 2) return n;

        int j = 1; // Because starting 2 elements are always fixed.
        for (int i = 2; i < n; i++) {
            if (arr[i] != arr[j-1]){
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
}
