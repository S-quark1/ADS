import db.StudentDB;
import db.Student;
import db.StudentRepos;
import graph.DijkstraSearch;
import graph.Search;
import graph.graphs.MyWeightedGraph;
import hash_and_bst.BST;
import hash_and_bst.HashTable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyWeightedGraph<String> graph = new MyWeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}
