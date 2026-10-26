import java.util.*;
public class BFSAndDFSGraph {
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int st){
        boolean[] vis = new boolean[adj.size()];
        vis[st] = true;

        Queue <Integer> q = new LinkedList<>();
        q.add(st);

        while (!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int nei : adj.get(curr)){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int st, boolean[] vis){
        vis[st] = true;
        System.out.print(st + " ");

        for(int nei : adj.get(st)){
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

        boolean[] vis = new boolean[adj.size()];
        dfs(adj, 0, vis);
    }
}
