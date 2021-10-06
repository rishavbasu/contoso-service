package org.rishav.contoso.domain;

public class FindAllPathsRequest {

	private final String start;
	private final String end;
	private final Integer maxIntermediateLandmarks;

	public FindAllPathsRequest(String start, String end, Integer maxIntermediateLandmarks) {
		super();
		this.start = start;
		this.end = end;
		this.maxIntermediateLandmarks = maxIntermediateLandmarks;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public Integer getMaxIntermediateLandmarks() {
		return maxIntermediateLandmarks;
	}

}
