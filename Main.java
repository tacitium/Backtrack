/**
 * Main.java
 * ALG3 Assessed Exercise 1
 * Name: Terence Tan Boon Kiat
 * GlasgowID: 2228167T
 * This is my own work.
 */

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        String inputFileName = args[0];

        FileReader reader = new FileReader(inputFileName);
        Scanner inScanner = new Scanner(reader);

        String line = inScanner.nextLine();
        Scanner lineScanner = new Scanner(line);

        int totalVertices = lineScanner.nextInt();
        int weight;

        // insert code here to build the graph from the input file
        Graph G = new Graph(totalVertices);
        
        try {
            for (int i = 0; i < totalVertices; i++) {
                // update information for vertex with index i
                line = inScanner.nextLine(); // read information
                lineScanner = new Scanner(line);
                for (int j = 0; j < totalVertices; j++) {
                    weight = lineScanner.nextInt();
                    if (weight > 0) {
                        G.getVertex(i).adjVerticesAdd(j, weight);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        
        line = inScanner.nextLine();
        lineScanner = new Scanner(line);

        int first = lineScanner.nextInt(); // start vertex
        int last = lineScanner.nextInt(); // end vertex

        reader.close();
        
        G.addStartVertex(first);
        G.tryBacktrack(0, last);

        System.out.println("Shortest distance from vertex " + first + " to vertex " + last + " is " + G.getShortestDistance());
        System.out.println("\nShortest path: " + G.getShortestPathtoString());

        // end timer and print total time
        long end = System.currentTimeMillis();
        System.out.println("\nElapsed time: " + (end - start) + " milliseconds");

    }

}
