package org.rishav.graph.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
	public void printAllPaths(Vertex<T> source, Vertex<T> destination, int depth) {
		Map<Vertex<T>, Boolean> visited = new HashMap<Vertex<T>, Boolean>();
		List<Vertex<T>> currentPath = new ArrayList<>();

		currentPath.add(source);
		dfs(source, destination, visited, currentPath, depth + 1);
		System.out.println(currentPath);
		
		//dfsWithoutRecursion(source, destination);
	}

	private void dfs(Vertex<T> source, Vertex<T> destination, Map<Vertex<T>, Boolean> visited,
			List<Vertex<T>> currentPath, int depth) {

		int currentDepth = 1;
		visited.put(source, Boolean.TRUE); // to avoid cycle

		if (source.equals(destination)) {
			System.out.println(currentPath);
		} else if (depth > 0) {

			Map<Vertex<T>, Q> adjacentVertices = getAdjacentVertices(source);
			for (Vertex<T> vertex : adjacentVertices.keySet()) {
				if (visited.get(vertex) == null || !visited.get(vertex)) {
					currentPath.add(vertex);
					dfs(vertex, destination, visited, currentPath, depth - 1);
					currentPath.remove(vertex);
				}
			}
			currentPath.remove(source);
		}

		visited.put(source, Boolean.FALSE);
	}
	
	public void dfsWithoutRecursion(Vertex<T> start, Vertex<T> destination) {
		List<Vertex<T>> currentPath = new ArrayList<>();
		
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		Map<Vertex<T>, Boolean> visited = new HashMap<Vertex<T>, Boolean>();
		stack.push(start);
		while (!stack.isEmpty()) {
			Vertex<T> current = stack.pop();
			
			if (visited.get(current) == null || !visited.get(current)) {
				visited.put(current, Boolean.TRUE);
				 currentPath.add(current);

				Map<Vertex<T>, Q> adjacentVertices = getAdjacentVertices(current);
				for (Vertex<T> dest : adjacentVertices.keySet()) {
					if (destination.equals(dest)) {
						System.out.println(currentPath);
						currentPath.clear();
						break;
					}
					if (visited.get(dest) == null || !visited.get(dest))
						stack.push(dest);
				}
				visited.put(current, Boolean.FALSE);
			}
		}
	}

	@Override
	public String toString() {
		return "Graph [adjacencyLists=" + adjacencyLists + "]";
	}

}
