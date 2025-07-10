import java.util.*;

public class Graph {
    int numVertices;
    List<List<Integer>> adjList;

    public Graph(int numVertices){
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>();
        for(int i=0; i<=numVertices; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printGraph(){
        for(int i=1; i<=numVertices; i++){
            System.out.print(i + ": ");
            for(int neighbour : adjList.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }

    public void BFS(Graph graph){
        int numVertices = graph.numVertices;
        List<List<Integer>> list = graph.adjList;

        List<Integer> res = new ArrayList<>();
        int[] visited = new int[numVertices + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = 1;

        while (!q.isEmpty()) {
            Integer node = q.remove();
            res.add(node);

            for(int neighbour : list.get(node)){
                if(visited[neighbour] != 1){
                    visited[neighbour] = 1;
                    q.add(neighbour);
                }
            }
        }

        System.out.println(res);
    }

    public void DFS(Graph graph){
        int numVertices = graph.numVertices;
        List<List<Integer>> list = graph.adjList;

        int[] visited = new int[numVertices + 1];
        List<Integer> res = new ArrayList<>();
        
        dfs(1, visited, list, res);

        System.out.println(res);
    }

    public void dfs(int node, int[] visited, List<List<Integer>> adj, List<Integer> res){
        visited[node] = 1;
        res.add(node);

        for(int neighbour : adj.get(node)){
            if(visited[neighbour] != 1){
                dfs(neighbour, visited, adj, res);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1, 2); 
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(6, 3); 

        graph.printGraph();
        graph.BFS(graph);
        graph.DFS(graph);
    }
}
