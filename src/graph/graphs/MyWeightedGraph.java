package graph.graphs;

import graph.vertices.MyWeightedVertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyWeightedGraph<T> {
    private final Map<T, MyWeightedVertex<T>> map;
    private final boolean bidirectional;

    public MyWeightedGraph() {
        this(false);
    }

    public MyWeightedGraph(boolean bidirectional) {
        this.bidirectional = bidirectional;
        map = new HashMap<>();
    }

    public void addVertex(T v) {
        map.put(v, new MyWeightedVertex<>(v));
    }

    public void addEdge(T from, T to, Double weight) {
        if (!hasVertex(from)) {
            addVertex(from);
        }
        if (!hasVertex(to)) {
            addVertex(to);
        }
        if (hasEdge(from, to) || from.equals(to)) {
            return;
        }
        MyWeightedVertex<T> fromVertex = map.get(from);
        MyWeightedVertex<T> toVertex = map.get(to);

        fromVertex.connectVertex(toVertex, weight);
        if (bidirectional) toVertex.connectVertex(fromVertex, weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).edgeCount();
        }

        if (!bidirectional)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T from, T to) {
        MyWeightedVertex<T> fromVertex = map.get(from);
        MyWeightedVertex<T> toVertex = map.get(to);

        return hasVertex(from) && fromVertex.hasConnection(toVertex);
    }

    public Iterable<Map.Entry<T, Double>> adjacencyList(T v) {
        if (!hasVertex(v)) return null;
        MyWeightedVertex<T> vertex = map.get(v);
        Map<T, Double> adj = new HashMap<>();

        for (Map.Entry<MyWeightedVertex<T>,
                Double> entry : vertex.edgesList()) {
            adj.put(entry.getKey().getVertex(), entry.getValue());
        }
        return adj.entrySet();
    }

//    public Iterable<MyWeightedVertex<T>> getConnectedVertices(T v) {
//        if (!hasVertex(v)) return null;
//        MyWeightedVertex<T> vertex = map.get(v);
//
//        return vertex.edgesList();
//    }
}
