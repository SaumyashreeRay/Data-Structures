package DiGraph_A5;

/**
 * COMP 410
 *
 * Make your class and its methods public! Don't modify this file! Begin by
 * creating a class that implements this interface.
 *
 */

public interface DiGraph_Interface {
	// ADT operations

	boolean addNode(long idNum, String label);

	boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel);

	boolean delNode(String label);

	boolean delEdge(String sLabel, String dLabel);

	long numNodes();

	long numEdges();

	String[] topoSort();
}