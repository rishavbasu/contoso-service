package org.rishav.contoso.service;

import org.rishav.graph.Edge;
import org.rishav.graph.Graph;
import org.rishav.graph.allPathsBetweenNodes;
import org.rishav.graph.exception.InvalidPathException;
import org.rishav.graph.exception.VertexNotFoundException;

public interface ContosoGameService {

	Graph<String> getLandmarkGraph();

	void addDirectRoute(Edge route) throws VertexNotFoundException;

	default void addDirectRoutes(Edge[] routes) throws VertexNotFoundException {
		for (Edge route : routes) {
			addDirectRoute(route);
		}
	}

	/**
	 * Calculates distance between landmarks via intermediate landmarks.
	 * 
	 * @param route List of landmarks.
	 * @return
	 * @throws InvalidPathException
	 * @throws VertexNotFoundException
	 */
	Double calculateDistance(String[] landmarks) throws InvalidPathException, VertexNotFoundException;

	public allPathsBetweenNodes<String> findAllPathsBetweenNodes(String source, String dest, int intermediateLandmarks)
			throws VertexNotFoundException, InvalidPathException;
}
