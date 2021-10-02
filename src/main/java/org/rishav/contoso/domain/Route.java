package org.rishav.contoso.domain;

public class Route {

	private final String start;
	private final String end;
	private final int distance;

	public Route(String start, String end, int distance) {
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

	public int getDistance() {
		return distance;
	}

}
