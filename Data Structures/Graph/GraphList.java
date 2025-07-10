package Graph;
import java.util.ArrayList;
import java.util.List;

public class GraphList {
    int numVertices;
    List<List<Integer>> adjList;

    public GraphList(int numVertices){
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
        for(int i=0; i<=numVertices; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printGraph(){
        for(int i=0; i<=numVertices; i++){
            System.out.print(i + ": ");
            for(int neighbour : adjList.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.printGraph();
    }
}
