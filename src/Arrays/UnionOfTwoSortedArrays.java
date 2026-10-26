package Arrays;
import java.util.Arrays;
public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {3,4,5,6,7};
        int[] ans = merge(arr1, arr2);
        int n = removeDuplicates(ans);
        System.out.println(Arrays.toString(Arrays.copyOf(ans, n)));
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int[] ans = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                ans[k++] = arr1[i++];
            }
            else ans[k++] = arr2[j++];
        }
        while (i < arr1.length){
            ans[k++] = arr1[i++];
        }
        while (j < arr2.length){
            ans[k++] = arr2[j++];
        }
        return ans;
    }

    public static int removeDuplicates(int[] arr){
        int n = arr.length;

        int j = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
}
