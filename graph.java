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
