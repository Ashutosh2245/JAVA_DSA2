package Arrays;
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if(arr[i] < arr[i-1] ){
                sorted = false;
                break;
            }
        }
        if (sorted) System.out.println("Sorted");
        else System.out.println("Not Sorted");
    }
}
