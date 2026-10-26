import java.util.*;
public class TopologicalSortGraph {

    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v){
        int[] ind = new int[adj.size()];

        for (int i = 0; i < v; i++) {
            for(int nei : adj.get(i)){
                ind[nei]++;
            }
        }

        Queue <Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(ind[i] == 0) q.add(i);
        }

        while (!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int nei : adj.get(curr)){
                ind[nei]--;

                if(ind[nei] == 0) q.add(nei);
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
