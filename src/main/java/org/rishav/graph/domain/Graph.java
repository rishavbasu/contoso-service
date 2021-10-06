package org.rishav.graph.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Graph<T> {

	/**
	 * Adjacency list of the graph
	 */
	private final Map<Vertex<T>, Map<Vertex<T>, Double>> adjacencyLists = new HashMap<>();

	/**
	 * @param v
	 */
	public void addVertex(Vertex<T> v) {
		adjacencyLists.putIfAbsent(v, new HashMap<Vertex<T>, Double>());
	}

	/**
	 * Creates a new Edge and updates the adjacent vertices Map.
	 * 
	 * @param v1
	 * @param v2
	 * @param distance
	 */
	public void addEdge(Vertex<T> v1, Vertex<T> v2, double distance) {
		// TODO add exception
		adjacencyLists.get(v1).put(v2, distance);
	}

	/**
	 * Returns adjacency list of a vertex.
	 * 
	 * @param data
	 * @return
	 */
	public Map<Vertex<T>, Double> getAdjacentVertices(Vertex<T> v) {
		// TODO add exception
		return adjacencyLists.get(v);
	}

	/**
	 * Finds all paths between two nodes with specified number of maximum intermediate nodes.
	 * @param source
	 * @param destination
	 * @param maxIntermediateNodes
	 * @return
	 */
	public AllPathsBetweenNodes<T> findAllPathsBetweenNodes(Vertex<T> source, Vertex<T> destination, int maxIntermediateNodes) {
		Map<Vertex<T>, Boolean> visited = new HashMap<Vertex<T>, Boolean>();
		List<Vertex<T>[]> allPaths = new ArrayList<>();
		List<Vertex<T>> currentPath = new ArrayList<>();
		currentPath.add(source);

		dfsFindAllPaths(source, destination, visited, currentPath, allPaths, maxIntermediateNodes);

		return new AllPathsBetweenNodes<T>(allPaths);
		// dfsWithoutRecursion(source, destination);
	}

	@SuppressWarnings("unchecked")
	private void dfsFindAllPaths(Vertex<T> source, Vertex<T> destination, Map<Vertex<T>, Boolean> visited,
			List<Vertex<T>> currentPath, List<Vertex<T>[]> allPaths, int maxIntermediateNodes) {

		visited.put(source, Boolean.TRUE); // to avoid cycle

		if (source.equals(destination)) {
			allPaths.add(currentPath.toArray(new Vertex[currentPath.size()]));
			currentPath = new ArrayList<Vertex<T>>();
		} else if (maxIntermediateNodes >= 0) {

			Map<Vertex<T>, Double> adjacentVertices = getAdjacentVertices(source);
			for (Vertex<T> vertex : adjacentVertices.keySet()) {
				if (visited.get(vertex) == null || !visited.get(vertex)) {
					currentPath.add(vertex);

					dfsFindAllPaths(vertex, destination, visited, currentPath, allPaths, maxIntermediateNodes - 1);
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

				Map<Vertex<T>, Double> adjacentVertices = getAdjacentVertices(current);
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
