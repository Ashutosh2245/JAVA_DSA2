package Arrays;
public class MinimizeOperations {

    public static int minOperations(int[] arr){
        int n = arr.length;
        int count = 0;

        int minLimit = Integer.MAX_VALUE;
        int maxLimit = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            minLimit = Math.min(minLimit, arr[i]);
            maxLimit = Math.max(maxLimit, arr[i]);
        }

        if(minLimit == maxLimit) return 0;

        int c1 = -1, c2 = -1;

        for(int i = 0; i < n; i++){
            if(arr[i] == maxLimit) c1 = i;
            break;
        }

        for (int i = n-1; i > 0; i--) {
            if(arr[i] == minLimit) c2 = i;
        }

        return (c1) + (n-c2) + 1;

        //return c1+c2;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int ans = minOperations(arr);
        System.out.println(ans);
    }
}
