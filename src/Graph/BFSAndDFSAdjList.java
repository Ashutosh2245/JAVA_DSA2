package Graph;
import java.util.*;
public class BFSAndDFSAdjList {
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int start){
        boolean[] visited = new boolean[adj.size()];
        visited[start] = true;

        Queue <Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int nei : adj.get(curr)){
                if(!visited[nei]){
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis){
        vis[start] = true;
        System.out.print(start + " ");

        for(int nei : adj.get(start)){
            if(!vis[nei]){
                dfs(adj, nei, vis);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        bfs(adj, 0);
        System.out.println();

        boolean[] vis = new boolean[v];
        dfs(adj, 0, vis);
    }
}
