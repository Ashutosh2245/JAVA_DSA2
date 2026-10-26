package Graph;
import java.util.*;
public class CountComponentsBFSandDFS {
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis){
        vis[start] = true;
        Queue <Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()){
            int front = q.poll();

            for (int nei : adj.get(front)){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
    public static int countBFS(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] vis = new boolean[v];

        int count = 0;
        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                count++;
                bfs(adj, i, vis);
            }
        }
        return count;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis){
        vis[start] = true;
        // System.out.print(start+" ");

        for(int nei : adj.get(start)){
            if(!vis[nei]){
                dfs(adj, nei, vis);
            }
        }
    }

    public static int countDFS(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] vis = new boolean[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                count++;
                dfs(adj, i, vis);
            }
        }
        return count;
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

        int count1 = countBFS(adj, v);
        int count2 = countDFS(adj, v);

        System.out.print(count1 +" "+ count2);
    }
}
