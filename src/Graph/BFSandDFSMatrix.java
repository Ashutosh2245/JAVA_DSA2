package Graph;
import java.util.*;
public class BFSandDFSMatrix {
    public static void bfs(int[][] adj, int start){
        boolean[] visited = new boolean[adj.length];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()){
            int front = q.poll();
            visited[front] = true;
            System.out.print(front + " ");

            for(int i = 0; i < adj.length; i++){
                if(adj[front][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void dfs(int[][] adj, int start, boolean[] visited){
        visited[start] = true;
        System.out.print(start+ " ");

        for (int i = 0; i < adj.length; i++){
            if(adj[start][i] == 1 && !visited[i]){
                dfs(adj, i, visited);
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

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        bfs(adj, 0);
        System.out.println();

        boolean[] visited = new boolean[v];
        dfs(adj, 0, visited);
    }
}
