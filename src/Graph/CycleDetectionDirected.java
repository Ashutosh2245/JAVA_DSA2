package Graph;
import java.util.*;
public class CycleDetectionDirected {
    public static boolean dfs(ArrayList<ArrayList <Integer>> adj, int node, boolean[] vis, boolean[] path){
        vis[node] = true;
        path[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                if(dfs(adj, nei, vis, path)){
                    return true;
                }
            }
            else{
                if(path[nei]){
                    return true;
                }
            }
        }
        path[node] = false;
        return false;
    }
    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] vis = new boolean[v];
        boolean[] path = new boolean[v];

        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                if(dfs(adj, i, vis, path)){
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

        ArrayList <ArrayList <Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(w);
        }
        System.out.println(detectCycle(adj, v));
    }
}
