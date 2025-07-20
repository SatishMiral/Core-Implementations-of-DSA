public class DisJointSetDS {
    
    // Static nested class so we can use it in main
    public static class DisJointSet {
        int[] rank;
        int[] parent;
        int[] size;

        DisJointSet(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                rank[i] = 0;      // initially all ranks are 0
                parent[i] = i;    // every node is its own parent
                size[i] = 1;      // every node is its own size
            }
        }

        // Find Ultimate Parent with Path Compression
        public int findUPar(int node) {
            if (node == parent[node]) return node;

            return parent[node] = findUPar(parent[node]); // Path compression
        }

        // Union by Size
        public void unionBySize(int u, int v) {
            int pu = findUPar(u);
            int pv = findUPar(v);
            
            if (pu == pv) return; // Already in same set

            if(size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
            else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }

        // Union by Rank
        public void unionByRank(int u, int v) {
            int pu = findUPar(u);
            int pv = findUPar(v);

            if (pu == pv) return; // Already in same set

            if (rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else if (rank[pv] > rank[pu]) {
                parent[pu] = pv;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public static void main(String[] args) {
        DisJointSet dj = new DisJointSet(7);
        dj.unionBySize(1, 2);
        dj.unionBySize(2, 3);
        dj.unionBySize(4, 5);
        dj.unionBySize(6, 7);
        dj.unionBySize(5, 6);

        if (dj.findUPar(3) == dj.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        dj.unionBySize(3, 7);

        if (dj.findUPar(3) == dj.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }
}
