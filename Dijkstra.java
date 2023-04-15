    //-----------------------------------------------------
    // Title: Dijkstra
    // Author: Feyzi Eren Gündoğdu
    // ID: 52417418978
    // Section: 1
    // Assignment: 1
    // Description: This is the class which implements djikstra's algorithm.
    //-----------------------------------------------
    import java.util.*;

    public class Dijkstra { 
        private int[] distTo; //array that holds the distances
        private int[] edgeTo; //array that holds which vertex is the previous vertex of the current vertex
        private boolean[] marked; //array that holds the information if the vertex is marked or not
    
        public Dijkstra(graph G, int start,int end) { 
            distTo = new int[G.V()]; //initializing the arrays
            edgeTo = new int[G.V()];
            marked = new boolean[G.V()];
            
            for (int i = 0; i < G.V(); i++) {
                distTo[i] = Integer.MAX_VALUE;
            }
            
            distTo[start] = 0;
            edgeTo[start] = -1;
            
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(G.V(), new Comparator<Integer>() { 
                public int compare(Integer i, Integer j) {
                    return Integer.compare(distTo[i], distTo[j]);
                }
            });
            
            pq.offer(start); //adding the start vertex to the priority queue
            
            while (!pq.isEmpty()) {
                int v = pq.poll(); //removing the vertex with the smallest distance from the priority queue so that the back tracking can be done
                marked[v] = true; // marking the vertex as visited
                
                for (int w : G.adj(v)) { //iterating through the adjacent vertices of the current vertex
                    if (!marked[w]) { //if the vertex is not visited the following can be done
                        if (w == end){
                            distTo[w] = distTo[v] + 1; //if the vertex is the end vertex the distance is updated
                            edgeTo[w] = v; 
                            return; //if the visited vertex is the end vertex loop is ended
                        }
                        if (distTo[w] > distTo[v] + 1) { //if the distance of the current vertex is smaller than the distance of the adjacent vertex the distance is updated
                            distTo[w] = distTo[v] + 1; 
                            edgeTo[w] = v;
                            
                            if (pq.contains(w)) { //if the vertex is already in the priority queue it is removed
                                pq.remove(w);
                            }
                            
                            pq.offer(w); 
                        }
                    }
                }
            }
        }
    
        public int distTo(int v) { //returns the distance of the vertex
            return distTo[v];
        }
    
        public boolean hasPathTo(int v) { 
            return distTo[v] != Integer.MAX_VALUE;
        }
    
        public Iterable<Integer> pathTo(int v) { // returns the path from the start vertex to the end vertex but in reverse order
                                                 // this method is not used in the main method it only for testing purposes
            if (!hasPathTo(v)) {
                return null;
            }
            
            Stack<Integer> path = new Stack<Integer>();
            
            for (int x = v; x != -1; x = edgeTo[x]) {
                path.push(x);
            }
    
            
            
            return path;
        }
    
        public void thePath(int v) { // the method which prints the path from the start vertex to the end vertex
            if (!hasPathTo(v)) {
                return;
            }
            
            Stack<Integer> path = new Stack<Integer>();
            
            for (int x = v; x != -1; x = edgeTo[x]) {
                path.push(x);
            }
            
            while (!path.isEmpty()) {
                System.out.print(path.pop() + " ");
            }
            
        }
    }