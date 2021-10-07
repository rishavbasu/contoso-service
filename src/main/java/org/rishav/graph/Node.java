package org.rishav.graph;

import java.util.Objects;

/**
 * Represents each node in adjacency list.
 * 
 * @author basur
 *
 */
public class Node<T, Q extends Number> {

	private final Vertex<T> adjacntVertex;
	private Q distance;

	public Node(Vertex<T> adjacntVertex, Q distance) {
		this.adjacntVertex = adjacntVertex;
		this.distance = distance;
	}
	
	public Node(Vertex<T> adjacntVertex) {
		this.adjacntVertex = adjacntVertex;
	}

	public Vertex<T> getAdjacntVertex() {
		return adjacntVertex;
	}

	public Q getDistance() {
		return distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjacntVertex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<?, ?> other = (Node<?, ?>) obj;
		return Objects.equals(adjacntVertex, other.adjacntVertex);
	}

	@Override
	public String toString() {
		return "Node [adjacntVertex=" + adjacntVertex + ", distance=" + distance + "]";
	}

}
