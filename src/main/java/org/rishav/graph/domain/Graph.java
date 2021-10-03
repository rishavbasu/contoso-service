package org.rishav.graph.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T, Q extends Number> {

	/**
	 * Adjacency list of the graph
	 */
	private final Map<Vertex<T>, Map<Vertex<T>, Q>> adjacencyLists = new HashMap<>();

	/**
	 * @param v
	 */
	public void addVertex(Vertex<T> v) {
		adjacencyLists.putIfAbsent(v, new HashMap<Vertex<T>, Q>());
	}

	/**
	 * Creates a new Edge and updates the adjacent vertices Map.
	 * 
	 * @param v1
	 * @param v2
	 * @param distance
	 */
	public void addEdge(Vertex<T> v1, Vertex<T> v2, Q distance) {
		// TODO add exception
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
		// TODO add exception
		return adjacencyLists.get(v);
	}

	// Prints all paths from source to destination
	public void printAllPaths(Vertex<T> source, Vertex<T> destination) {
		Map<Vertex<T>, Boolean> visited = new HashMap<Vertex<T>, Boolean>();
		List<Vertex<T>> currentPath = new ArrayList<>();

		currentPath.add(source);
		dfs(source, destination, visited, currentPath);
		System.out.println(currentPath);
	}

	private void dfs(Vertex<T> source, Vertex<T> destination, Map<Vertex<T>, Boolean> visited,
			List<Vertex<T>> currentPath) {
		visited.put(source, Boolean.TRUE); // to avoid cycle

		if (source.equals(destination)) {
			System.out.println(currentPath);
			return;
		}

		Map<Vertex<T>, Q> adjacentVertices = getAdjacentVertices(source);
		for (Vertex<T> vertex : adjacentVertices.keySet()) {
			if (visited.get(vertex) == null || !visited.get(vertex)) {
				currentPath.add(vertex);
				dfs(vertex, destination, visited, currentPath);
				currentPath.remove(vertex);
			}
		}

		visited.put(source, Boolean.FALSE);
	}

	@Override
	public String toString() {
		return "Graph [adjacencyLists=" + adjacencyLists + "]";
	}

}
