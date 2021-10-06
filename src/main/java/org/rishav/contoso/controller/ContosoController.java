package org.rishav.contoso.controller;

import org.rishav.contoso.service.ContosoGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contoso")
public class ContosoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContosoController.class);

	@Autowired
	ContosoGame contosoGame;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    	public ResponseEntity<Void> getRoot() {
        	return new ResponseEntity<>(HttpStatus.OK);
   	 }

	@PostMapping("/test")
	public Integer calculateDistance(String[] route) {
		return contosoGame.calculateDistance(route);
	}
}
