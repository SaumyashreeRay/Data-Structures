package DiGraph_A5;

import java.util.HashMap;

public class Vertex {
	HashMap<String, Edge> OutEdges; // vertex is source node, contains
									// destination label
	HashMap<String, Edge> InEdges; // vertex is the destination node, contains
									// source label
	private long idNum;
	private String label;
	int inCount;

	public Vertex(long idNum, String label) {
		this.idNum = idNum;
		this.label = label;
		OutEdges = new HashMap<String, Edge>();
		InEdges = new HashMap<String, Edge>();
		inCount = 0;
	}

	public String getLabel() {
		return label;
	}

	public long getIdNum() {
		return idNum;
	}
}
