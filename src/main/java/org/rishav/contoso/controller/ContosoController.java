package org.rishav.contoso.controller;

import org.rishav.contoso.domain.Route;
import org.rishav.contoso.service.ContosoGameService;
import org.rishav.contoso.service.exception.PathNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contoso")
public class ContosoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContosoController.class);
	
	@Autowired
	ContosoGameService contosoGame;
	
	@PostMapping("/addroutes")
	public void addDiretRoutes(@RequestBody Route[] routes) {
		contosoGame.addDirectRoutes(routes);
		LOGGER.info("Routes added to graph :: ", routes);
	}

	@PostMapping("/calculatedistance")
	public Integer calculateDistance(@RequestBody String[] ladnmarks) throws PathNotFoundException{
		return contosoGame.calculateDistance(ladnmarks);
	}
}
