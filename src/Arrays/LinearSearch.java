package Arrays;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 3;

        int i;
        for(i = 0; i < arr.length; i++){
            if(arr[i] == target){
                System.out.println("Element Found");
                break;
            }
        }
        if(i == arr.length) System.out.println("Element not found");
    }
}
