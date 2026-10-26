import java.util.*;
public class BFSAndDFSMatrix {
    public static void bfs(int[][] adj, int st){
        boolean[] vis = new boolean[adj.length];
        vis[st] = true;

        Queue <Integer> q = new LinkedList<>();
        q.add(st);

        while (!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int i = 0; i < adj.length; i++) {
                if(adj[curr][i] == 1 && !vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public static void dfs(int[][] adj, int st, boolean[] vis){
        vis[st] = true;
        System.out.print(st + " ");

        for (int i = 0; i < adj.length; i++) {
            if(adj[st][i] == 1 && !vis[i]){
                dfs(adj, i, vis);
            }
        }
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
        bfs(adj, 0);
        System.out.println();

        boolean[] vis = new boolean[adj.length];
        dfs(adj, 0, vis);
    }
}
