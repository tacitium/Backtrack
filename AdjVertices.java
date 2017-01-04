/**
 * AdjVertices.java
 * ALG3 Assessed Exercise 1
 * Name: Terence Tan Boon Kiat
 * GlasgowID: 2228167T
 * This is my own work.
 */

public class AdjVertices implements Comparable<AdjVertices>{

    private int vertexNumber; // index of the adjacent vertex
    private int vertexWeight; // weight of the adjacent vertex

    public AdjVertices(int n, int w) {
        setVertexNumber(n);
        setVertexWeight(w);
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public final void setVertexNumber(int n) {
        vertexNumber = n;
    }

    public int getVertexWeight() {
        return vertexWeight;
    }

    public final void setVertexWeight(int n) {
        vertexWeight = n;
    }

    public int compareTo(AdjVertices a) {
        return Integer.compare(getVertexWeight(), a.getVertexWeight());
    }

}
