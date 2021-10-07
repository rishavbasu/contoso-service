package org.rishav.contoso.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.rishav.contoso.domain.FindAllPathsRequest;
import org.rishav.contoso.service.ContosoGameService;
import org.rishav.graph.Edge;
import org.rishav.graph.AllPathsBetweenNodes;
import org.rishav.graph.exception.InvalidPathException;
import org.rishav.graph.exception.VertexNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@Validated
public class ContosoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContosoController.class);

	@Autowired
	private ContosoGameService contosoGame;

	@GetMapping("/")
	public ResponseEntity<Void> getRoot() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Add all routes")
	@PostMapping("/contoso/addroutes")
	public void addDiretRoutes(@RequestBody(required = true) @Valid Edge[] edges) {
		contosoGame.addDirectRoutes(edges);
		LOGGER.info("Routes added to graph :: {}", edges);
	}

	@Operation(summary = "Calculate total distance from satrt to end landmark")
	@PostMapping("/contoso/calculatedistance")
	public Double calculateDistance(@RequestBody @NotEmpty String[] ladnmarks)
			throws InvalidPathException, VertexNotFoundException {

		return contosoGame.calculateDistance(ladnmarks);
	}

	@Operation(summary = "Find routes between two landmarks with number of intermediate landmarks")
	@PostMapping("/contoso/findAllPathsBetweenNodes")
	public AllPathsBetweenNodes<String> findAllPathsBetweenNodes(@RequestBody FindAllPathsRequest findAllPathsRequest)
			throws InvalidPathException, VertexNotFoundException {

		return contosoGame.findAllPathsBetweenNodes(findAllPathsRequest.getStart(), findAllPathsRequest.getEnd(),
				findAllPathsRequest.getMaxIntermediateLandmarks());
	}
}
