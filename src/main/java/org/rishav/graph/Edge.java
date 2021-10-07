package org.rishav.graph;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Edge {

	@NotEmpty(message = "start node cant be empty")
	private final String start;

	@NotEmpty(message = "end node cant be empty")
	private final String end;

	@NotNull(message = "distance cant be empty")
	@Min(value = 1)
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
