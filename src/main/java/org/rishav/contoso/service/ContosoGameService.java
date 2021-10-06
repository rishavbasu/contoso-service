package org.rishav.contoso.service;

import org.rishav.contoso.service.exception.PathNotFoundException;
import org.rishav.graph.domain.Graph;
import org.rishav.graph.domain.AllPathsBetweenNodes;
import org.rishav.graph.domain.Edge;

public interface ContosoGameService {

	Graph<String> getLandmarkGraph();

	void addDirectRoute(Edge route);

	default void addDirectRoutes(Edge[] routes) {
		for (Edge route : routes) {
			addDirectRoute(route);
		}
	}

	/** Calculates distance between landmarks via intermediate landmarks.
	 * @param route List of landmarks.
	 * @return
	 * @throws PathNotFoundException 
	 */
	Double calculateDistance(String[] landmarks) throws PathNotFoundException;

	public AllPathsBetweenNodes<String> findAllPathsBetweenNodes(String source, String dest, int intermediateLandmarks);
}
