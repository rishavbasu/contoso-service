package org.rishav.contoso.service;

import org.rishav.contoso.domain.Route;
import org.rishav.graph.domain.Graph;

public interface ContosoGame {

	Graph<String, Integer> getLandmarkGraph();

	void addDirectRoute(Route route);

	Integer calculateDistance(String[] route);

	public Integer getPaths(String source, String dest);
}
