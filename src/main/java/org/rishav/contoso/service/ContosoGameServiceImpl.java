package org.rishav.contoso.service;

import java.util.Map;

import org.rishav.contoso.domain.Route;
import org.rishav.contoso.service.exception.PathNotFoundException;
import org.rishav.graph.domain.Graph;
import org.rishav.graph.domain.Vertex;
import org.springframework.stereotype.Service;

@Service
public class ContosoGameServiceImpl implements ContosoGameService {

	private final Graph<String, Integer> landmarkGraph = new Graph<String, Integer>();

	public Graph<String, Integer> getLandmarkGraph() {
		return landmarkGraph;
	}

	/**
	 * Adds source & destination landmarks & edge between these two landmarks to the
	 * land mark graph.
	 * 
	 * @param route
	 */
	public void addDirectRoute(Route route) {
		Vertex<String> v1 = new Vertex<>(route.getStart());
		Vertex<String> v2 = new Vertex<>(route.getEnd());
		landmarkGraph.addVertex(v1);
		landmarkGraph.addVertex(v2);
		landmarkGraph.addEdge(v1, v2, route.getDistance());
	}

	public Integer calculateDistance(String[] landmarks) throws PathNotFoundException {
		Integer totalDistance = 0;
		if (landmarks.length < 2)
			return totalDistance; // TODO
		else {
			Vertex<String> start;
			Map<Vertex<String>, Integer> adjacentVertices;

			for (int i = 0; i < landmarks.length - 1; i++) {
				start = new Vertex<String>(landmarks[i]);
				adjacentVertices = landmarkGraph.getAdjacentVertices(start);
				Vertex<String> next = new Vertex<String>(landmarks[i + 1]);

				Integer distance = adjacentVertices.get(next);
				if (distance == null || distance == 0) {
					throw new PathNotFoundException("Path Not Found"); // Intermediate landmark is not reachable
				} else {
					totalDistance += distance;
				}
			}
		}

		return totalDistance;
	}

	public Integer getPaths(String source, String dest) {
		landmarkGraph.printAllPaths(new Vertex<String>(source), new Vertex<String>(dest), 10);
		return 0;
	}
}
