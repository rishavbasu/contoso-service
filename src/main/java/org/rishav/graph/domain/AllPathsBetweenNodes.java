package org.rishav.graph.domain;

import java.util.List;

public class AllPathsBetweenNodes<T> {

	private final Integer numberOfRoutes;
	private final List<Vertex<T>[]> routes;

	public AllPathsBetweenNodes(List<Vertex<T>[]> routes) {
		super();
		this.numberOfRoutes = routes.size();
		this.routes = routes;
	}

	public Integer getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public List<Vertex<T>[]> getRoutes() {
		return routes;
	}

}
