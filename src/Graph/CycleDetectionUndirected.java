package Graph;
import java.util.*;
public class CycleDetectionUndirected {
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] vis){
        vis[node] = true;
        for(int nei : adj.get(node)){
            if(!vis[nei]){
                if(dfs(adj, nei, node, vis)){
                    return true;
                }
            }
            else{
                if(nei != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                if(dfs(adj, i, -1, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();


        ArrayList <ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        System.out.println(hasCycle(adj, v));
    }
}
