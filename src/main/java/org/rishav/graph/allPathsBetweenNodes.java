package org.rishav.graph;

import java.util.List;

public class allPathsBetweenNodes<T> {

	private final Integer numberOfRoutes;
	private final List<Vertex<T>[]> routes;

	public allPathsBetweenNodes(List<Vertex<T>[]> routes) {
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
