package Graph;
import java.util.*;
public class TopologicalSort {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] inDegree = new int[v];

        for(int i = 0; i < v; i++) {       // InDegree calculate
            for(int nei : adj.get(i)) {
                inDegree[nei]++;
            }
        }
        System.out.print("InDegree of vertices: ");
        for(int ele : inDegree) System.out.print(ele + " ");

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++) {     // InDegree 0 wale nodes
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int nei : adj.get(node)) {
                inDegree[nei]--;
                if(inDegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {

            int u = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(w);
        }

        System.out.println("Adjacency List: ");
        for (int i = 0; i < v; i++) {
            System.out.print(i+ " -> ");
            for(int nei : adj.get(i)){
                System.out.print(nei + " ");
            }
            System.out.println();
        }


        ArrayList<Integer> ans = topologicalSort(adj, v);
        System.out.print("\nTopological Order: ");
        for(int node : ans) {
            System.out.print(node + " ");
        }
    }
}