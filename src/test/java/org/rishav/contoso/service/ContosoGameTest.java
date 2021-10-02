package org.rishav.contoso.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.rishav.contoso.domain.Route;

class ContosoGameTest {
	
	ContosoGame contosoGame = new ContosoGame();

	@Test
	void testAddDirectRoute() {
		contosoGame.addDirectRoute(new Route("A", "B", 3));
		contosoGame.addDirectRoute(new Route("B", "C", 9));
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		contosoGame.calculateDistance(new String[] {"A", "B"});
		System.out.println(contosoGame.getLandmarkGraph());
	}

}
