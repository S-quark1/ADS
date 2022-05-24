package graph.vertices;

import java.util.*;

public class MyVertex<V> implements Vertex<V> {
    private final V data;
    private final Set<MyVertex<V>> connectedVertices;

    public MyVertex(V data) {
        this.data = data;
        this.connectedVertices = new HashSet<>();
    }

    public void connectVertex(MyVertex<V> dest) {
        connectedVertices.add(dest);
    }

    public void removeConnection(MyVertex<V> dest) {
        connectedVertices.remove(dest);
    }

    public boolean hasConnection(MyVertex<V> dest) {
        return connectedVertices.contains(dest);
    }

    public int edgeCount() {
        return connectedVertices.size();
    }

    public V getVertex(){
        return data;
    }

    public Iterable<MyVertex<V>> edgesList() {
        return connectedVertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVertex<?> myVertex = (MyVertex<?>) o;
        return Objects.equals(data, myVertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
