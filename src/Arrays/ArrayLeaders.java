package Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        int n = arr.length;
        ArrayList <Integer> list = new ArrayList<>();
        int max = arr[n-1];
        list.add(max);
        for (int i = n-2; i >= 0; i--) {
            if(arr[i] >= max){
                max = arr[i];
                list.add(arr[i]);
            }
        }
        Collections.reverse(list);
        System.out.println(list);
    }
}
