import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class src {
  
  public static ArrayList<Graph> graphList = new ArrayList<Graph>();
  
  public static int t, n; //# of instances and vertices per instance
  
  public static String DFSString; //String for DF traversals
  
  protected static class Graph {
    int instance;
    ArrayList<Node> nodeList;
    public Graph (int size, int instanceNumber) {
      this.instance = instanceNumber;
      this.nodeList = new ArrayList<Node>(size);
    }
  }
  
  protected static class Node {
    public char name;
    public boolean visited;
    public LinkedList<Edge> edgesLeaving = new LinkedList<Edge>();
    
    public Node(char nameInput) {
      this.visited = false;
      this.name = nameInput;
    }
  }
  
  protected static class Edge {
    public Node source;
    public Node target;
    
    public Edge(Node sourceNode, Node targetNode) {
      this.source = sourceNode;
      this.target = targetNode;
    }
  }
  
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    
    String buffer = "";
    
    t = scnr.nextInt();
    for (int tLoop = 0; tLoop < t; tLoop++) {
      
      n = scnr.nextInt();
      
      Graph g = new Graph(n, tLoop + 1);
      
      boolean containsNode;
      
      scnr.nextLine();
      
      for (int buildGraph = 0; buildGraph < n; buildGraph++) {         //Builds graph. Runs n times to allow for each node to get edges
        buffer += scnr.nextLine().replace(" ", "");                    //Remove spaces for easier iteration
        
        for (int bufChar = 0; bufChar < buffer.length(); bufChar++) {  //Nested for loop adds all unique nodes from line
          containsNode = false;
          
          for (Node elementToCheck : g.nodeList) {
            if (elementToCheck != null && elementToCheck.name == buffer.charAt(bufChar)) {
              containsNode = true;
            }
          }
          
          if (!containsNode) {
            g.nodeList.add(new Node(buffer.charAt(bufChar)));
          }
        }                                                              //Loop end. All unique nodes from line added
        
        Node firstInLine = null;
        
        if (buffer.length() > 1) {                                     //Add edges
          for (Node getFirstInLine : g.nodeList) {
            if (getFirstInLine != null && getFirstInLine.name == buffer.charAt(0)) {
              firstInLine = getFirstInLine;
            }
          }
          
          for (Node getSourceNode: g.nodeList) {
            for (int i = 1; i < buffer.length(); i++) {
              if (getSourceNode != null && getSourceNode.name == buffer.charAt(i)) {
                Edge edgeFromTarget = new Edge(firstInLine, getSourceNode);
                firstInLine.edgesLeaving.add(edgeFromTarget); 
              }
            }
          }
        }
        buffer = "";
      } //close n loop

      graphList.add(g);
      
    } //close t loop
    scnr.close();
    
    depthFirstSearch();
  }
  
  public static void DFSHelper(int cur, Graph g) {
    
    Node curNode = g.nodeList.get(cur);
    
    curNode.visited = true;
    DFSString += curNode.name + " ";
    
    for (Edge e : curNode.edgesLeaving) {
      if (!e.target.visited) {
        DFSHelper(g.nodeList.indexOf(e.target), g);
      }
    }
  }
  
  
  public static void depthFirstSearch() {
    for (Graph g : graphList) {
      DFSString = "";
      DFSHelper(0, g);
      for (Node disconnectedNodes : g.nodeList) {
        if (disconnectedNodes.edgesLeaving.size() == 0) {
          DFSString += disconnectedNodes.name + " ";
        }
      }
      
      DFSString = DFSString.trim();
      
      if (g.instance < graphList.size()) {
        DFSString += "\n";
      }
      
      System.out.print(DFSString);
    }
  }
} //end src
