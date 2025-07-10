package Graph;
public class GraphMatrix {
    int[][] matrix;
    int numVertices;

    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices + 1][numVertices + 1];
    }

    // For undirected graph (1 based indexing)
    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public void printGraph() {
        for (int i = 1; i <= numVertices; i++) {  // start from 1
            System.out.print(i + ": ");
            for (int j = 1; j <= numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }    

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.printGraph();
    }
}