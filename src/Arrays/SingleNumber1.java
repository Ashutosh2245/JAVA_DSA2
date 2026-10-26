package Arrays;
public class SingleNumber1 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        int ans = 0;
        for(int ele : arr){
            ans = ans ^ ele;
        }
        System.out.println(ans);
    }
}
