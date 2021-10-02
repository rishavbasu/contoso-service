package org.rishav.graph.domain;

import java.util.Objects;

/**
 * Each vertex of a graph.
 * 
 * @author basur
 *
 */
public class Vertex<T> {

	public final T label;

	public Vertex(T label) {
		super();
		this.label = label;
	}

	public T getLabel() {
		return label;
	}

	@Override
	public int hashCode() {
		return Objects.hash(label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex<?> other = (Vertex<?>) obj;
		return Objects.equals(label, other.label);
	}

	@Override
	public String toString() {
		return "Vertex [" + label + "]";
	}

}
