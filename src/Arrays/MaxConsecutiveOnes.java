package Arrays;
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,0,1,1};
        int count = 0, max = 0;
        for(int ele : arr){
            if(ele == 1){
                count++;
                max = Math.max(max, count);
            }
            else{
                count = 0;
            }
        }
        System.out.println(max);
    }
}
