import java.util.*;
public class LongestSubstringWithExactlyKDiffCharacters {
    public static int longestSubstring(String s, int k){
        int n = s.length();
        int left = 0, maxLen = -1;
        int right;
        HashMap <Character, Integer> map = new HashMap<>();

        for (right = 0; right < n; right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while (map.size() > k){
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);

                if(map.get(c) == 0){
                    map.remove(c);
                }
                left++;
            }
            if(map.size() == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = left; i < right; i++){
            ans.append(s.charAt(i));
        }
        System.out.println("Resultant SubArray: "+ans);
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int ans = longestSubstring(s, k);
        System.out.println("Max Substring length: "+ ans);
    }
}
