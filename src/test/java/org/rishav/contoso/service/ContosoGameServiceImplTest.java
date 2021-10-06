package org.rishav.contoso.service;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.rishav.contoso.service.exception.PathNotFoundException;
import org.rishav.graph.domain.Edge;

public class ContosoGameServiceImplTest {

	ContosoGameService contosoGame = new ContosoGameServiceImpl();

	@Before
	public void setup() {
		contosoGame.addDirectRoute(new Edge("A", "B", 3D));
		contosoGame.addDirectRoute(new Edge("B", "C", 9D));
		contosoGame.addDirectRoute(new Edge("C", "D", 3D));
		contosoGame.addDirectRoute(new Edge("D", "E", 6D));
		contosoGame.addDirectRoute(new Edge("A", "D", 4D));
		contosoGame.addDirectRoute(new Edge("D", "A", 5D));
		contosoGame.addDirectRoute(new Edge("C", "E", 2D));
		contosoGame.addDirectRoute(new Edge("A", "E", 4D));
		contosoGame.addDirectRoute(new Edge("E", "B", 1D));

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
	public void testFindAllPathsBetweenNodes() {
		assertEquals(2, contosoGame.findAllPathsBetweenNodes("A", "C", 2).getNumberOfRoutes().intValue());
	}
}
