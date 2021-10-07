package org.rishav.contoso.service;

import org.rishav.graph.Edge;
import org.rishav.graph.Graph;
import org.rishav.graph.allPathsBetweenNodes;
import org.rishav.graph.exception.InvalidPathException;
import org.rishav.graph.exception.NodeNotFoundException;

public interface ContosoGameService {

	Graph<String> getLandmarkGraph();

	void addDirectRoute(Edge route);

	default void addDirectRoutes(Edge[] routes) {
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
	 * @throws NodeNotFoundException
	 */
	Double calculateDistance(String[] landmarks) throws InvalidPathException, NodeNotFoundException;

	public allPathsBetweenNodes<String> findAllPathsBetweenNodes(String source, String dest, int intermediateLandmarks)
			throws NodeNotFoundException, InvalidPathException;
}
