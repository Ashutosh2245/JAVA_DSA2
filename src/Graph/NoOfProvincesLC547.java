package Graph;
import java.util.*;
public class NoOfProvincesLC547 {
    public static void dfs(int[][] adj, int start, boolean[] vis){
        vis[start] = true;
        for (int i = 0; i < adj.length; i++){
            if(adj[start][i] == 1 && !vis[i]){
                vis[i] = true;
                dfs(adj, i, vis);
            }
        }
    }

    public static int provinces(int[][] adj){
        int ans = 0;
        boolean[] vis = new boolean[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if(!vis[i]){
                ans++;
                dfs(adj, i, vis);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] adj = new int[v][v];

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();

            adj[u][w] = 1;
            adj[w][u] = 1;
        }

        int ans = provinces(adj);
        System.out.println(ans);
    }
}
