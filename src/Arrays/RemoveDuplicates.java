package Arrays;
import java.util.Arrays;
import java.util.HashSet;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3,3};
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        System.out.println("Length after removals: "+ (j+1));
        System.out.println();
        System.out.println("Modified Array: "+Arrays.toString(arr));
        System.out.print("Required Array: ");
        for(int i = 0; i < j+1; i++){
            System.out.print(arr[i]+" ");
        }
    }
}



/*
package Arrays;
import java.util.Arrays;
import java.util.HashSet;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3,3};

        HashSet <Integer> set = new HashSet<>();
        for(int ele : arr) set.add(ele);

        int[] ans = new int[set.size()];
        int i = 0;
        for(int ele : set){
            ans[i] = ele;
            i++;
        }
        System.out.println(Arrays.toString(ans));
    }
}
*/