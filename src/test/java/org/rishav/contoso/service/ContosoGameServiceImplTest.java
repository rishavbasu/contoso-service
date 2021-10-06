package org.rishav.contoso.service;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.rishav.contoso.domain.Route;
import org.rishav.contoso.service.exception.PathNotFoundException;

public class ContosoGameServiceImplTest {

	ContosoGameService contosoGame = new ContosoGameServiceImpl();

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
	}

	@Test
	public void testCalculateDistance() throws PathNotFoundException {
		assertEquals(12, contosoGame.calculateDistance(new String[] { "A", "B", "C" }).intValue());
	}

	@Test(expected = PathNotFoundException.class)
	public void testCalculateDistanceNotFound() throws PathNotFoundException {
		contosoGame.calculateDistance(new String[] { "A", "E", "D" });
	}

	@Test
	public void testGetPaths() throws PathNotFoundException {
		assertEquals(2, contosoGame.getPaths("A", "A").intValue());
	}
}
