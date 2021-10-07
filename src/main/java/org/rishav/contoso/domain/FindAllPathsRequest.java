package org.rishav.contoso.domain;

import javax.validation.constraints.NotEmpty;

public class FindAllPathsRequest {

	@NotEmpty
	private final String start;

	@NotEmpty
	private final String end;

	@NotEmpty
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
