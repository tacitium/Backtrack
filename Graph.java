/**
 * Graph.java 
 * ALG3 Assessed Exercise 1 
 * Name: Terence Tan Boon Kiat 
 * GlasgowID: 2228167T
 * This is my own work.
 */

import java.util.LinkedList;

public class Graph {

    private Vertex[] vertices; // vertices array
    private int totalVertices; // total vertices in graph
    private LinkedList<Integer> currentPath;
    private LinkedList<Integer> shortestPath;
    private int currentDistance;
    private int shortestDistance;

    public Graph(int n) {
        setSize(n);
        createVertices(n);
        currentPath = new LinkedList<>();
        shortestPath = new LinkedList<>();
        setCurrentDistance(0);
        setShortestDistance(Integer.MAX_VALUE);
    }

    public final int getSize() {
        return totalVertices;
    }

    public final void setSize(int n) {
        totalVertices = n;
    }

    public final void createVertices(int n) {
        vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }
    }

    public Vertex getVertex(int i) {
        return vertices[i];
    }

    public void setVertex(int i) {
        vertices[i] = new Vertex(i);
    }

    public void addStartVertex(int start) {
        currentPath.addFirst(start);
    }

    public LinkedList<Integer> getCurrentPath() {
        return currentPath;
    }

    public String getCurrentPathtoString() {
        String s = "";
        int size = currentPath.size();
        for (int i = 0; i < size; i++) {
            if (i != size-1) {
                s += currentPath.get(i) + " ";
            } else {
                s += currentPath.get(i);
            }
        }
        return s;
    }

    public LinkedList<Integer> getShortestPath() {
        return shortestPath;
    }

    public String getShortestPathtoString() {
        String s = "";
        int size = shortestPath.size();
        for (int i = 0; i < size; i++) {
            if (i != size-1) {
                s += shortestPath.get(i) + " ";
            } else {
                s += shortestPath.get(i);
            }
        }
        return s;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public final void setCurrentDistance(int n) {
        currentDistance = n;
    }

    public int getShortestDistance() {
        return shortestDistance;
    }

    public final void setShortestDistance(int n) {
        shortestDistance = n;
    }
    
    // method for backtrack
    public void tryBacktrack(int current, int end) {
        int currentIndex = currentPath.get(current);
        Vertex currentVertex = vertices[currentIndex]; // get vertex by current input

        try {
            // loop through each unvisited vertex adjacent to the last vertex in currentPath)
            for (AdjVertices a : currentVertex.getAdjVerticesList()) {
                int num = a.getVertexNumber();
                int weight = a.getVertexWeight();
                Vertex next = vertices[num];

                if (next.getVisited() == false) { // check if next vertex is visited
                    currentPath.add(num); // add vertex to path if not visited
                    currentDistance += weight; // add weight to current distance
                    next.setVisited(true); // set next vertex as visited

                    if (currentDistance < shortestDistance) { // compare distance
                        if (num == end) { // check if next vertex is last vertex
                            shortestPath.clear(); // ensure shortest path is empty
                            for(Integer i : currentPath){
                                shortestPath.add(i); // copy all items in currentPath into shortestPath
                            }
                            shortestDistance = currentDistance; // update distance
                        } else {
                            // recursive to go to next element in path
                            tryBacktrack(current + 1, end);
                        }
                    }

                    currentPath.removeLast(); // remove last item from current path
                    next.setVisited(false); // set next as unvisited
                    currentDistance -= weight; // remove weight from current distance
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
