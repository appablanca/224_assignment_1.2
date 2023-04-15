    //-----------------------------------------------------
    // Title: Graph
    // Author: Feyzi Eren Gündoğdu
    // ID: 52417418978
    // Section: 1
    // Assignment: 1
    // Description: This is the graph class which inculdes graph data strucutre abd bag data structure.
    //-----------------------------------------------
import java.util.*;
@SuppressWarnings("unchecked") //warning suppression for aesthetic purposes
public class graph {
    public int V; //V is the amount of vertices
    public Bag<Integer>[] adj; //adj is the adjacency list
    
    
    public graph (int V) { //constructor
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        
    }

    Boolean isCyclicUtil(int v, Boolean visited[],int parent){
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
 
            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    Boolean isCyclic(){
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++){
            visited[i] = false;
        }
        for (int u = 0; u < V; u++) {
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
        }
        return false;
    }


    

    

    

    public void addE(int v, int w) { //method that adds edges to the graph
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) { // returns the adjacency list of a vertex
        return adj[v];
    }

    

    public int V() {//returns the amount of vertices
        return V;
    }

    public int minDistance(int[] dist, boolean[] visited) { //returns the vertex with the minimum distance
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < V; v++) {
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }


    public int[] shortestCycleWithSourceAndDestination (int s, int d) { //returns the shortest cycle that starts at s and includes d
        int[] dist = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[s] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && adj[u].contains(v) && dist[u] != Integer.MAX_VALUE && dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                }
            }
        }
        int[] path = new int[dist[d]+1];
        int i = 0;
        int j = d;
        while (j != s) {
            path[i] = j;
            j = parent[j];
            i++;
        }
        path[i] = s;
        return path;
    }
    

    

    

    
    

    







    










    public class Bag<Item> implements Iterable<Item> { //bag data structure

        public Node first;
        public int N;

        public class Node { //node class
            Item item;
            Node next;
            
        }

        public boolean isEmpty() {
            return first == null;
        }

        

        public boolean contains(Item v) { //contains method
            for (Item item : this) {
                if (item == v) {
                    return true;
                }
            }
            return false;
        }
            



        public int size() {
            return N;
        }

        

        public void add(Item item) {//add method
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }

        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        public class ListIterator implements Iterator<Item> {//iterator class
            public Node current = first;
            public boolean hasNext() {
                return current != null;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

        public String toString() { //toString method used while testing the algorithm 
            String s = "";
            for (Item item : this) {
                s += item + " ";
            }
            return s;
        }
    }























   
}
