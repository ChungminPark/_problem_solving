import java.util.ArrayList;
import java.util.List;

public class Graph {

    public int N;
    public List<List<Integer>> adj;
    public List<Boolean> vistied;

    public Graph() {
        N = 0;
    }
    public Graph(int n) {
        N = n;
        adj = new ArrayList<>(N);
        vistied = new ArrayList<>(N);

        for (int i=0; i<N; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<N; i++)
            vistied.add(false);
    }

    public void addEdge(int u, int v) {
        List<Integer> temp;

        temp = adj.get(u);
        temp.add(v);
        adj.set(u, temp);

        temp = adj.get(v);
        temp.add(u);
        adj.set(v, temp);
    }

    public void dfs() {
        dfs(0);
    }

    private void dfs(int curr) {
        vistied.set(curr, true);
        System.out.println("node " + curr + " visited");
        for(int next: adj.get(curr)) {
            if(!vistied.get(next)) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(9);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(1, 5);
        G.addEdge(3, 4);
        G.addEdge(4, 5);
        G.addEdge(2, 6);
        G.addEdge(2, 8);
        G.addEdge(6, 7);
        G.addEdge(6, 8);
        G.dfs();
    }
}
