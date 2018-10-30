package DiGraph_A5;

import java.util.*;
import java.util.Map.Entry;

public class DiGraph implements DiGraph_Interface {
	private HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();
	private HashSet<Long> edge_ids = new HashSet<Long>();
	private HashSet<Long> vertex_ids = new HashSet<Long>();

	public DiGraph() { // default constructor
	}
/*	addNode
    in: unique id number of the node (0 or greater)
        string for name
          you might want to generate the unique number automatically
          but this operation allows you to specify any integer
          both id number and label must be unique
    return: boolean
              returns false if node number is not unique, or less than 0
              returns false if label is not unique (or is null)
              returns true if node is successfully added */
	@Override
	public boolean addNode(long idNum, String label) {
		if (idNum < 0 || label == null || vertex_ids.contains(idNum) || vertices.containsKey(label)) {
			return false;
		}
		Vertex v = new Vertex(idNum, label);
		vertex_ids.add(idNum);
		vertices.put(label, v);
		return true;
	}

	/*addEdge
    in: unique id number for the new edge, 
        label of source node,
        label of destination node,
        weight for new edge (use 1 by default)
        label for the new edge (allow null)
    return: boolean
              returns false if edge number is not unique or less than 0
              returns false if source node is not in graph
              returns false if destination node is not in graph
              returns false is there already is an edge between these 2 nodes
              returns true if edge is successfully added */
	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		Vertex source = vertices.get(sLabel);
		Vertex destination = vertices.get(dLabel);
		if ((edge_ids.contains(idNum)) || (idNum < 0)) {
			return false;
		}
		if (source == null || destination == null) {
			return false;
		}
		// checking if an edge exists
		boolean contains = false, containsSource = false, containsDestination = false;
		for (Long s : edge_ids) {
			if (s == idNum) {
				contains = true;
			}
		}
		for (Edge e : source.OutEdges.values()) {
			if (e.getSLabel().equals(sLabel) && e.getDLabel().equals(dLabel)) {
				containsSource = true;
			}
		}

		for (Edge e : destination.InEdges.values()) {
			if (e.getDLabel().equals(dLabel) && e.getSLabel().equals(sLabel)) {
				containsDestination = true;
			}
		}
		if (contains || (containsSource && containsDestination)) {
			return false;
		}

		Edge e = new Edge(idNum, sLabel, dLabel, weight, eLabel);
		edge_ids.add(idNum);
		source.OutEdges.put(dLabel, e);
		destination.InEdges.put(sLabel, e);
		return true;
	}

	/*delNode
      in: string 
            label for the node to remove
      out: boolean
             return false if the node does not exist
             return true if the node is found and successfully removed */
	@Override
	public boolean delNode(String label) {
		if (!vertices.containsKey(label)) {
			return false;
		}
		Vertex toRemove = vertices.get(label);
//		for (int n = 0; n < toRemove.OutEdges.size(); n++) {
//		      Edge e = toRemove.OutEdges.get(n);
//		      delEdge(e.getSLabel(), e.getDLabel());
//		      edge_ids.remove(e.getID());
//		 }
//		for (int n = 0; n < toRemove.InEdges.size(); n++) {
//		      Edge e = toRemove.InEdges.get(n);
//		      delEdge(e.getSLabel(), e.getDLabel());
//		      edge_ids.remove(e.getID());
//		 }
		for(Edge e : toRemove.InEdges.values()){
			Vertex s = vertices.get(e.getSLabel());
			s.OutEdges.remove(e.getDLabel());
			edge_ids.remove(e.getID());
		}
		for(Edge e : toRemove.OutEdges.values()){
			Vertex d = vertices.get(e.getDLabel());
			d.InEdges.remove(e.getSLabel());
			edge_ids.remove(e.getID());
		}

		vertices.remove(label, toRemove);
		vertex_ids.remove(toRemove.getIdNum());
		return true;

	}

	/*delEdge
      in: string label for source node
          string label for destination node
      out: boolean
             return false if the edge does not exist
             return true if the edge is found and successfully removed*/
	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		Vertex s = vertices.get(sLabel);
		Vertex d = vertices.get(dLabel);

		if (s == null || d == null) {
			return false;
		}
		// check if edge exists
		boolean containsSource = false, containsDestination = false;
		for (Edge e : s.OutEdges.values()) {
			if (e.getSLabel().equals(sLabel)) {
				containsSource = true;
//				s.OutEdges.remove(e.getDLabel(), e);
//				edge_ids.remove(e.getID());
				break;
			}
		}
		for (Edge e : d.InEdges.values()) {
			if (e.getDLabel().equals(dLabel)) {
				containsDestination = true;
//				d.InEdges.remove(e.getSLabel(), e);
//				edge_ids.remove(e.getID());
				break;
			}
		}
		
		if (!containsSource || !containsDestination) {
			return false;
		}
		for (Edge e : s.OutEdges.values()) {
			if (e.getSLabel().equals(sLabel)) {
				s.OutEdges.remove(e.getDLabel(), e);
				edge_ids.remove(e.getID());
				break;
			}
		}
		for (Edge e : d.InEdges.values()) {
			if (e.getDLabel().equals(dLabel)) {
				d.InEdges.remove(e.getSLabel(), e);
				edge_ids.remove(e.getID());
				break;
			}
		}
		
		
		return true;
	}

	/*numNodes
    in: nothing
    return: integer 0 or greater
              reports how many nodes are in the graph*/
	@Override
	public long numNodes() {
		return vertices.size();
	}

	/* numEdges
      in: nothing
      return: integer 0 or greater
                reports how many edges are in the graph*/
	@Override
	public long numEdges() {
		return edge_ids.size();
	}

	/*topoSort:
      in: nothing
      return: array of node labels (strings)
                if there is no topo sort (a cycle) return null for the array
                if there is a topo sort, return an array containing the node
                  labels in order*/
	@Override
	public String[] topoSort() {
		Queue<String> topo = new LinkedList<String>();
		Queue<Vertex> q = new LinkedList<Vertex>();

		for (Vertex v : vertices.values()) {
			v.inCount = v.InEdges.size(); // set inCount for each vertex
			if (v.inCount == 0) {
				q.add(v); // add vertex found with indegree 0 to queue
			}
		}

		while (!q.isEmpty()) {
			Vertex temp = q.remove(); // remove from queue
			topo.add(temp.getLabel()); // add to topo

			Iterator<Entry<String, Edge>> iter = temp.OutEdges.entrySet().iterator();
			while (iter.hasNext()) {
				Edge curr = iter.next().getValue();
				Vertex neighbor = vertices.get(curr.getDLabel());
				neighbor.inCount--; // decrement neighbor's in edge
				if (neighbor.inCount == 0) {
					q.add(neighbor);
				}
			}
		}
		if (topo.size() == vertices.size()) {
			String[] e = topo.toArray(new String[topo.size()]);
			return e;
		}
		return null;
	}
}