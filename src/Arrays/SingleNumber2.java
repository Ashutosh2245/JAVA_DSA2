package Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,3};
        int ans = single(arr);
        System.out.println(ans);
    }
    public static int single(int[] arr) {

        HashMap <Integer, Integer> map = new HashMap<>();
        for (int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(Map.Entry <Integer, Integer> map2 : map.entrySet()){
            if(map2.getValue() == 1){
                return map2.getKey();
            }
        }
        return -1;
    }
}
