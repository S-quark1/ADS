package graph.vertices;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyWeightedVertex<V> implements Vertex<V> {
    private final V data;
    private final Map<MyWeightedVertex<V>, Double> connectedVertices;

    public MyWeightedVertex(V data) {
        this.data = data;
        this.connectedVertices = new HashMap<>();
    }

    public void connectVertex(MyWeightedVertex<V> dest, Double weight) {
        connectedVertices.put(dest, weight);
    }

    public void removeConnection(MyWeightedVertex<V> dest, Double weight) {
        connectedVertices.remove(dest, weight);
    }

    public boolean hasConnection(MyWeightedVertex<V> dest) {
        return connectedVertices.containsKey(dest);
    }

    public int edgeCount() {
        return connectedVertices.size();
    }

    public V getVertex(){
        return data;
    }

//    public Double getWeight(){
//        return data;
//    }

//    public Iterable<Double> getWeight(){
//        return connectedVertices.values();
//    }

    public Iterable<Map.Entry<MyWeightedVertex<V>, Double>> edgesList() {
        return connectedVertices.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyWeightedVertex<?> myVertex = (MyWeightedVertex<?>) o;
        return Objects.equals(data, myVertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
