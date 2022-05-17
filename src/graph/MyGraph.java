package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private final Map<Vertex, List<Vertex>> map;
    private final boolean bidirectional;

    public MyGraph() {
        this(false);
    }

    public MyGraph(boolean bidirectional) {
        this.bidirectional = bidirectional;
        map = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex from, Vertex to) {
        if (!hasVertex(from)) {
            addVertex(from);
        }
        if (!hasVertex(to)) {
            addVertex(to);
        }
        if (hasEdge(from, to) || from.equals(to)) {
            return;
        }
        map.get(from).add(to);
        if (bidirectional) map.get(to).add(from);
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex from, Vertex to) {
        List<Vertex> list = map.get(from);
        return list != null && list.contains(to);
    }
}
