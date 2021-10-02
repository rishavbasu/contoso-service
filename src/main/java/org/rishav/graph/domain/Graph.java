package org.rishav.graph.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T, Q extends Number> {

	/**
	 * Adjacency list of the graph
	 */
	private final Map<Vertex<T>, Map<Vertex<T>, Q>> adjacencyLists = new HashMap<>();

	/**
	 * @param v
	 */
	public void addVertex(Vertex<T> v) {
		adjacencyLists.putIfAbsent(v, new HashMap<Vertex<T>,Q>());
	}

	/**
	 * Creates a new Edge and updates the adjacent vertices Map.
	 * 
	 * @param v1
	 * @param v2
	 * @param distance
	 */
	public void addEdge(Vertex<T> v1, Vertex<T> v2, Q distance) {
		//TODO add exception
		adjacencyLists.get(v1).put(v2, distance);
		adjacencyLists.get(v2).put(v1, distance);
	}

	/**
	 * Returns adjacency list of a vertex.
	 * 
	 * @param data
	 * @return
	 */
	public Map<Vertex<T>, Q> getAdjacentVertices(Vertex<T> v) {
		//TODO add exception
		return adjacencyLists.get(v);
	}

	@Override
	public String toString() {
		return "Graph [adjacencyLists=" + adjacencyLists + "]";
	}

}
