package Arrays;
import java.util.Arrays;
public class RearrangeAlternatePositiveAndNegative {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        int[] ans = rearrange(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] rearrange(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        int i = 0, j = 1;
        for(int ele : arr){
            if(ele > 0){
                ans[i] = ele;
                i += 2;
            }
            else{
                ans[j] = ele;
                j += 2;
            }
        }
        return ans;
    }
}


/*
package Arrays;
import java.util.Arrays;
public class RearrangeAlternatePositiveAndNegative {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        int[] ans = rearrange(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] rearrange(int[] arr) {
        int n = arr.length;
        int[] arr1 = new int[n / 2];
        int[] arr2 = new int[n / 2];
        int i = 0, j = 0;
        for (int ele : arr) {
            if (ele > 0) {
                arr1[i] = ele;
                i++;
            } else {
                arr2[j] = ele;
                j++;
            }
        }
        int[] ans = new int[n];
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                ans[k] = arr1[k/2];
            }
            else{
                ans[k] = arr2[k/2];
            }
        }
        return ans;
    }
}
 */