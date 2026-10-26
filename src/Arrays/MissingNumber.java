package Arrays;
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,4};
        int n = arr.length;
        int exp = (n+1) * (n+2)/2;
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        System.out.println(exp-sum);
    }
}
