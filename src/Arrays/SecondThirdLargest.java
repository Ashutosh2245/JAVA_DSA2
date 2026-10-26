package Arrays;
public class SecondThirdLargest {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5};
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        int tMax = Integer.MIN_VALUE;

        for(int ele : arr){
            if(ele > max){
                tMax = sMax;
                sMax = max;
                max = ele;
            }
            else if(ele > sMax && ele != max){
                tMax = sMax;
                sMax = ele;
            }
            else if(ele > tMax && ele != sMax && ele != max){
                tMax = ele;
            }
        }
        System.out.println("Max: "+max);
        System.out.println("Second Max: "+sMax);
        System.out.println("Third Max: "+tMax);
    }
}
