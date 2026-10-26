package Graph;
import java.util.*;
public class Topological {

    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v){
        int[] inDegree = new int[v];

        for (int i = 0; i < v; i++) {
            for(int nei : adj.get(i)){
                inDegree[nei]++;
            }
        }

        Queue <Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(inDegree[i] == 0){
                q.add(i);
            }
        }


        while (!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");

            for(int nei : adj.get(node)){
                inDegree[nei]--;

                if(inDegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <ArrayList<Integer>> adj = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            int u = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(w);
        }

        topologicalSort(adj, v);

    }
}
