package org.rishav.contoso.service;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.rishav.contoso.domain.Route;

public class ContosoGameTest {

	ContosoGame contosoGame = new ContosoGameService();

	@Before
	public void setup() {
		contosoGame.addDirectRoute(new Route("A", "B", 3));
		contosoGame.addDirectRoute(new Route("B", "C", 9));
		contosoGame.addDirectRoute(new Route("C", "D", 3));
		contosoGame.addDirectRoute(new Route("D", "E", 6));
		contosoGame.addDirectRoute(new Route("A", "D", 4));
		contosoGame.addDirectRoute(new Route("D", "A", 5));
		contosoGame.addDirectRoute(new Route("C", "E", 2));
		contosoGame.addDirectRoute(new Route("A", "E", 4));
		contosoGame.addDirectRoute(new Route("E", "B", 1));

//		contosoGame.addDirectRoute(new Route("B", "F", 1));
//		contosoGame.addDirectRoute(new Route("F", "G", 1));
//		contosoGame.addDirectRoute(new Route("G", "C", 1));
	}

	@Test
	public void testAddDirectRoute() {

		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		System.out.println(contosoGame.calculateDistance(new String[] { "A", "E", "B", "C", "D" }));
		System.out.println(contosoGame.getLandmarkGraph());
	}

	@Test
	public void testGetPaths() {
		contosoGame.getPaths("A", "C");
	}

}
