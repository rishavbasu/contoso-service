package org.rishav.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Each vertex of a graph.
 * 
 * @author basur
 *
 */
public class Vertex<T> {

	private final T label;

	private final List<Node<T>> adjacentNodes;

	public Vertex(T label) {
		super();
		this.label = label;
		this.adjacentNodes = new ArrayList<Node<T>>();
	}

	public Vertex(T label, List<Node<T>> adjacentNodes) {
		super();
		this.label = label;
		this.adjacentNodes = adjacentNodes;
	}

	public T getLabel() {
		return label;
	}

	public List<Node<T>> getAdjacentNodes() {
		return adjacentNodes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjacentNodes, label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return Objects.equals(adjacentNodes, other.adjacentNodes) && Objects.equals(label, other.label);
	}

	@Override
	public String toString() {
		return "Vertex [label=" + label + ", adjacentNodes=" + adjacentNodes + "]";
	}
}
