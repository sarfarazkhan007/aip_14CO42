import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
		 
		
class BreadthFirstSearchExample 
{
	/**
	 * @param args
	 */
	 private Queue<Node> queue;
	 static ArrayList<Node> nodes=new ArrayList<Node>();
	 static class Node
	 {
		 char data;
		 boolean visited;
		 
		 Node(char data)
		 {
			this.data=data;
		 }
	 }
	 
	 public BreadthFirstSearchExample()
	 {
		queue = new LinkedList<Node>();
	 }
	 
	 // find neighbors of node using adjacency matrix
	 // if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
	 public ArrayList<Node> findNeighbours(char adjacency_matrix[][],Node x)
	 {
		 int nodeIndex=-1;
		 
		 ArrayList<Node> neighbours=new ArrayList<Node>();
		 for (int i = 0; i < nodes.size(); i++) 
		 {
			 if(nodes.get(i).equals(x))
			 {
				nodeIndex=i;
				break;
			 }
		 }
		 
		 if(nodeIndex!=-1)
		 {
			 for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) 
			 {
				 if(adjacency_matrix[nodeIndex][j]==1)
				 {
					neighbours.add(nodes.get(j));
				 }
			 }
		 }
		 return neighbours;
	 }
	 
	 public void bfs(char adjacency_matrix[][], Node node)
	 {
		 queue.add(node);
		 node.visited=true;
		 while (!queue.isEmpty())
		 {
			 Node element=queue.remove();
			 System.out.print(element.data + "\t");
			 ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,element);
			 for (int i = 0; i < neighbours.size(); i++) 
			 {
				 Node n=neighbours.get(i);
				 if(n!=null && !n.visited)
				 {
					 queue.add(n);
					 n.visited=true;					 
				 }
			 }
			 
		 }
	 }
	 
	 public static void main(String arg[])
	 {
	 
		 Node node1 =new Node('A');
		 Node node2 =new Node('B');
		 Node node3 =new Node('C');
		 Node node4 =new Node('D');
		 Node node5 =new Node('E');
		 Node node6 =new Node('F');
		 Node node7 =new Node('G');
		 Node node8 =new Node('H');
		 Node node9 =new Node('I');
		 Node node10 =new Node('J');
		 
		 
		 nodes.add(node1);
		 nodes.add(node2);
		 nodes.add(node3);
		 nodes.add(node4);
		 nodes.add(node5);
		 nodes.add(node6);
		 nodes.add(node7);
		 nodes.add(node8);
		 nodes.add(node9);
		 nodes.add(node10);
		 
		 
		 char adjacency_matrix[][] = {
		 {0,1,1,1,0,0,0,0,0,0}, // Node 1: A
		 {0,0,0,0,1,1,0,0,0,0}, // Node 2 :B
		 {0,0,0,0,0,0,1,1,0,0}, // Node 3: C
		 {0,0,0,0,0,0,0,0,1,1}, // Node 4: D
		 {0,0,0,0,0,0,0,0,0,0}, // Node 5: E
		 {0,0,0,0,0,0,0,0,0,0}, // Node 6: F
		 {0,0,0,0,0,0,0,0,0,0}, // Node 7: G
		 {0,0,0,0,0,0,0,0,0,0}, // Node 7: H
		 {0,0,0,0,0,0,0,0,0,0}, // Node 7: I
		 {0,0,0,0,0,0,0,0,0,0}, // Node 7: J
		 };
		 
		 System.out.println("The BFS traversal of the graph is ");
		 BreadthFirstSearchExample bfsExample = new BreadthFirstSearchExample();
		 bfsExample.bfs(adjacency_matrix, node1);
			 
	}
}
