package graph.graphs;

import graph.vertices.MyVertex;

import java.util.*;

public class MyGraph<T> {
    private final Map<T, MyVertex<T>> map;
    private final boolean bidirectional;

    public MyGraph() {
        this(false);
    }

    public MyGraph(boolean bidirectional) {
        this.bidirectional = bidirectional;
        map = new HashMap<>();
    }

    public void addVertex(T v) {
        map.put(v, new MyVertex<>(v));
    }

    public void addEdge(T from, T to) {
        MyVertex<T> fromVertex = map.get(from);
        MyVertex<T> toVertex = map.get(to);

        if (!hasVertex(from)) {
            addVertex(from);
        }
        if (!hasVertex(to)) {
            addVertex(to);
        }
        if (hasEdge(from, to) || from.equals(to)) {
            return;
        }
        fromVertex.connectVertex(toVertex);
        if (bidirectional) toVertex.connectVertex(fromVertex);
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
        MyVertex<T> fromVertex = map.get(from);
        MyVertex<T> toVertex = map.get(to);

        return hasVertex(from) && fromVertex.hasConnection(toVertex);
    }

    public Iterable<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;
        MyVertex<T> vertex = map.get(v);
        List<T> adj = new LinkedList<>();

        for (MyVertex<T> a: vertex.edgesList()) { // returns Iterable<MyVertex<V>> / Set<MyVertex<V>> / connectedVertices
            adj.add(a.getVertex());
        }
        return adj;
    }
}
