package Graph;
import java.util.*;
public class RedundantConnectionLC684 {
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int target, boolean[] visited) {

        if(node == target) {
            return true;
        }

        visited[node] = true;

        for(int neighbour : adj.get(node)) {

            if(!visited[neighbour]) {

                if(dfs(adj, neighbour, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

            // Check: kya u se v already connected hai?
            if(dfs(adj, u, v, visited)) {
                return new int[]{u, v};
            }

            // Cycle nahi hai, edge add karo
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[]{};
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] edges = new int[n][2];

        for(int i = 0; i < n; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        int[] ans = findRedundantConnection(edges);

        System.out.println(ans[0] + " " + ans[1]);
    }
}