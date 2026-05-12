package Graphs;
import java.util.*;

public class Graph {

    public static class Edge {
        // Attributes of the Edge class.
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static class WeightedEdge {
        int src;
        int dest;
        int wt;

        public WeightedEdge (int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph (List<Edge>[] graph) {
        for (int x = 0; x < graph.length; x++) graph[x] = new ArrayList<Edge>();

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void createWeightedGraph (List<WeightedEdge>[] weightedGraph) {
        for (int x = 0; x < weightedGraph.length; x++) weightedGraph[x] = new ArrayList<WeightedEdge>();

        weightedGraph[0].add(new WeightedEdge(0, 2, 2));

        weightedGraph[1].add(new WeightedEdge(1, 2, 10));
        weightedGraph[1].add(new WeightedEdge(1, 3, 0));

        weightedGraph[2].add(new WeightedEdge(2, 0, 1));
        weightedGraph[2].add(new WeightedEdge(2, 1,10));
        weightedGraph[2].add(new WeightedEdge(2, 3, -1));

        weightedGraph[3].add(new WeightedEdge(3, 1, 0));
        weightedGraph[3].add(new WeightedEdge(3, 2, -1));
    }
    public static void main(String[] args) {
        int V = 4; // No. of Vertices.
        
        List<Edge>[] graph = new ArrayList[V];
        List<WeightedEdge>[] weightedGraph = new ArrayList[V];
        createGraph(graph);
        createWeightedGraph(weightedGraph);

        //printing each node's neighbors

        for (int x = 0; x < graph.length; x++) {
            System.out.printf("Neighbors of %d", x);
            System.out.println();
            for (int y = 0; y < graph[x].size(); y++) {
                System.out.println(graph[x].get(y).dest);
            }
        }
        System.out.println();

        for (int x = 0; x < weightedGraph.length; x++) {
            System.out.printf("Neighbors of %d", x);
            System.out.println();
            for (int y = 0; y < graph[x].size(); y++) {
                System.out.println("dest = " + weightedGraph[x].get(y).dest + ", wt = " + weightedGraph[x].get(y).wt);
            }
        }
    }
}
