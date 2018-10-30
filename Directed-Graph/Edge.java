package DiGraph_A5;

public class Edge {
	private long idNum;
	private String sourceLabel;
	private String destinationLabel;
	private long weight;
	private String edgeLabel;

	public Edge(long id, String sLabel, String dLabel, long edgeWeight, String eLabel) {
		idNum = id;
		sourceLabel = sLabel;
		destinationLabel = dLabel;
		weight = edgeWeight;
		edgeLabel = eLabel;
	}

	public long getID() {
		return idNum;
	}

	public String getSLabel() {
		return sourceLabel;
	}

	public String getDLabel() {
		return destinationLabel;
	}

	public long getEdgeWeight() {
		return weight;
	}

	public String getELabel() {
		return edgeLabel;
	}
}
