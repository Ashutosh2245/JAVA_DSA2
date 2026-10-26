package Arrays;
import java.util.Arrays;
public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,3,4,5};
        int[] arr2 = {3,3,4,5,6,6,7};


        int[] ans = intersection(arr1, arr2);
        System.out.println(Arrays.toString(ans));

    }
    public static int[] intersection(int[] a, int[] b){
        int n = removeDuplicates(a);
        int m = removeDuplicates(b);

        int i = 0, j = 0, k = 0;
        int[] ans = new int[Math.min(n, m)];

        while (i < n && j < m){
            if(a[i] > b[j]) j++;
            else if(b[j] > a[i]) i++;
            else if(a[i] == b[j]){
                ans[k] = a[i];
                k++; j++; i++;
            }
        }
        return Arrays.copyOf(ans, k);
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
