package org.rishav.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.rishav.graph.exception.InvalidPathException;
import org.rishav.graph.exception.VertexNotFoundException;

public class Graph<T> {

	/**
	 * Adjacency list of the graph
	 */
	private final Map<T, Vertex<T>> vertices = new HashMap<>();

	/**
	 * @param v
	 */
	public void addVertex(Vertex<T> v) {
		vertices.putIfAbsent(v.getLabel(), v);
	}

	public Vertex<T> getVertex(T label) throws VertexNotFoundException {
		Vertex<T> vertex = vertices.get(label);
		if (vertex == null) {
			throw new VertexNotFoundException("Node " + label + "does not exist");
		}

		return vertex;
	}

	/**
	 * Creates a new Edge and updates the adjacent vertices Map.
	 * 
	 * @param v1
	 * @param v2
	 * @param distance
	 * @throws VertexNotFoundException
	 * @throws InvalidPathException
	 */
	public void addEdge(T v1, T v2, double distance) throws VertexNotFoundException, InvalidPathException {
		if (v1.equals(v2)) {
			throw new InvalidPathException("Source & destinations cant be same");
		}

		Node<T> adjacentNode = new Node<T>(getVertex(v2), distance);
		getVertex(v1).getAdjacentNodes().add(adjacentNode);
	}

	/**
	 * Returns adjacency list of a vertex.
	 * 
	 * @param label
	 * @return
	 * @throws VertexNotFoundException
	 */
	public List<Node<T>> getAdjacentVertices(T label) throws VertexNotFoundException {

		return getVertex(label).getAdjacentNodes();
	}

	/**
	 * Finds all paths between two nodes with specified number of maximum
	 * intermediate nodes.
	 * 
	 * @param source
	 * @param destination
	 * @param maxIntermediateNodes
	 * @return
	 * @throws VertexNotFoundException
	 * @throws InvalidPathException
	 */
	public AllPathsBetweenNodes<T> findAllPathsBetweenNodes(T source, T destination, int maxIntermediateNodes)
			throws VertexNotFoundException, InvalidPathException {
		
		if (source.equals(destination)) {
			throw new InvalidPathException("Source & destinations cant be same");
		}
		
		Vertex<T> sourceVertex = getVertex(source);
		Vertex<T> destinationVertex = getVertex(destination);

		Map<Vertex<T>, Boolean> visited = new HashMap<Vertex<T>, Boolean>();
		List<Vertex<T>[]> allPaths = new ArrayList<>();
		List<Vertex<T>> currentPath = new ArrayList<>();
		currentPath.add(sourceVertex);

		dfsFindAllPaths(sourceVertex, destinationVertex, visited, currentPath, allPaths, maxIntermediateNodes);

		return new AllPathsBetweenNodes<T>(allPaths);
		// dfsWithoutRecursion(source, destination);
	}

	@SuppressWarnings("unchecked")
	private void dfsFindAllPaths(Vertex<T> source, Vertex<T> destination, Map<Vertex<T>, Boolean> visited,
			List<Vertex<T>> currentPath, List<Vertex<T>[]> allPaths, int maxIntermediateNodes)
			throws VertexNotFoundException, InvalidPathException {

		visited.put(source, Boolean.TRUE); // to avoid cycle

		if (source.equals(destination)) {
			allPaths.add(currentPath.toArray(new Vertex[currentPath.size()]));
			currentPath = new ArrayList<Vertex<T>>();
		} else if (maxIntermediateNodes >= 0) {

			List<Node<T>> adjacentVertices = getAdjacentVertices(source.getLabel());
			for (Node<T> node : adjacentVertices) {
				Vertex<T> adjacntVertex = node.getAdjacntVertex();
				if (visited.get(adjacntVertex) == null || !visited.get(adjacntVertex)) {
					currentPath.add(adjacntVertex);

					dfsFindAllPaths(node.getAdjacntVertex(), destination, visited, currentPath, allPaths, maxIntermediateNodes - 1);
					currentPath.remove(adjacntVertex);
				}
			}
			currentPath.remove(source);
		}
		visited.put(source, Boolean.FALSE);
	}

	public void dfsWithoutRecursion(Vertex<T> start, Vertex<T> destination) throws VertexNotFoundException {
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
		return "Graph [adjacencyLists=" + vertices + "]";
	}

}
