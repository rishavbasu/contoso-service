package org.rishav.graph.domain;

public class Edge {

	private final String start;
	private final String end;
	private final Double distance;

	public Edge(String start, String end, Double distance) {
		super();
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public Double getDistance() {
		return distance;
	}

}
