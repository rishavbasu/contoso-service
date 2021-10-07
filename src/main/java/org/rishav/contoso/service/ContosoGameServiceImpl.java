package org.rishav.contoso.service;

import java.util.Map;

import org.rishav.graph.Edge;
import org.rishav.graph.Graph;
import org.rishav.graph.Vertex;
import org.rishav.graph.allPathsBetweenNodes;
import org.rishav.graph.exception.InvalidPathException;
import org.rishav.graph.exception.NodeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ContosoGameServiceImpl implements ContosoGameService {

	private final Graph<String> landmarkGraph = new Graph<String>();

	public Graph<String> getLandmarkGraph() {
		return landmarkGraph;
	}

	/**
	 * Adds source & destination landmarks & edge between these two landmarks to the
	 * land mark graph.
	 * 
	 * @param route
	 */
	public void addDirectRoute(Edge route) {
		Vertex<String> v1 = new Vertex<>(route.getStart());
		Vertex<String> v2 = new Vertex<>(route.getEnd());
		landmarkGraph.addVertex(v1);
		landmarkGraph.addVertex(v2);
		landmarkGraph.addEdge(v1, v2, route.getDistance().doubleValue());
	}

	public Double calculateDistance(String[] landmarks) throws InvalidPathException, NodeNotFoundException {
		double totalDistance = 0;
		if (landmarks.length < 2)
			return totalDistance; // TODO
		else {
			Vertex<String> start;
			Map<Vertex<String>, Double> adjacentVertices;

			for (int i = 0; i < landmarks.length - 1; i++) {
				start = new Vertex<String>(landmarks[i]);
				adjacentVertices = landmarkGraph.getAdjacentVertices(start);
				Vertex<String> next = new Vertex<String>(landmarks[i + 1]);

				Double distance = adjacentVertices.get(next);
				if (distance == null || distance == 0) {
					throw new InvalidPathException("Path Not Found"); // Intermediate landmark is not reachable
				} else {
					totalDistance += distance;
				}
			}
		}

		return totalDistance;
	}

	public allPathsBetweenNodes<String> findAllPathsBetweenNodes(String source, String dest, int intermediateLandmarks)
			throws NodeNotFoundException, InvalidPathException {
		return landmarkGraph.findAllPathsBetweenNodes(new Vertex<String>(source), new Vertex<String>(dest),
				intermediateLandmarks);
	}
}
