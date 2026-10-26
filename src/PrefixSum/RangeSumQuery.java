package PrefixSum;
import java.util.*;
public class RangeSumQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] prefix = new int[n+1];

        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            String id = sc.next();
            int L = sc.nextInt();
            int R = sc.nextInt();

            long sum = prefix[R+1] - prefix[L];

            System.out.println("QueryID: " + id + " | TotalUsage: " + sum);
        }
    }
}