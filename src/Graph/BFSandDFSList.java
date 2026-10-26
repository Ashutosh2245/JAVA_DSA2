package Graph;
import java.util.*;
public class BFSandDFSList {

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int start){
        boolean[] visited = new boolean[adj.size()];
        visited[start] = true;

        Queue <Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()){
            int front = q.poll();
            System.out.print(front+" ");

            for(int nei : adj.get(front)){
                if(!visited[nei]){
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node+" ");

        for (int nei : adj.get(node)){
            if(!visited[nei]){
                dfs(adj, nei, visited);
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
            adj.get(w).add(u); //For undirected Graphs
        }

        for (int i = 0; i < v; i++) {
            System.out.print(i+" -> ");
            for(int node : adj.get(i)){
                System.out.print(node+" ");
            }
            System.out.println();
        }

        bfs(adj, 0);
        System.out.println();

        boolean[] visited = new boolean[v];
        dfs(adj, 0, visited);
    }
}
