package org.rishav.contoso.service;

import org.rishav.contoso.domain.Route;
import org.rishav.contoso.service.exception.PathNotFoundException;
import org.rishav.graph.domain.Graph;

public interface ContosoGameService {

	Graph<String, Integer> getLandmarkGraph();

	void addDirectRoute(Route route);

	default void addDirectRoutes(Route[] routes) {
		for (Route route : routes) {
			addDirectRoute(route);
		}
	}

	/** Calculates distance between landmarks via intermediate landmarks.
	 * @param route List of landmarks.
	 * @return
	 * @throws PathNotFoundException 
	 */
	Integer calculateDistance(String[] landmarks) throws PathNotFoundException;

	public Integer getPaths(String source, String dest);
}
