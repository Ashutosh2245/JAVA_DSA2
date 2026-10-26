package Arrays;
import java.util.Arrays;
public class LeftRotate {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        int k = 2;
        leftRotate(arr1, k);
        System.out.println(Arrays.toString(arr1));
        rightRotate(arr2, k);
        System.out.println(Arrays.toString(arr2));

    }
    public static void leftRotate(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);

    }
    public static void rightRotate(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);
    }
    public static void reverse(int[] arr, int i, int j){
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
