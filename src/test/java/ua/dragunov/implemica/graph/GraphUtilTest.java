package ua.dragunov.implemica.graph;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphUtilTest {
    Graph cities;
    Node gdansk;
    Node bydgoszcz;
    Node torun;
    Node warszawa;


    @Before
    public void setUp() throws Exception {
        cities = new Graph();
        gdansk = new Node("gdansk");
        bydgoszcz = new Node("bydgoszcz");
        torun = new Node("torun");
        warszawa = new Node("warszawa");

        gdansk.addDestination(bydgoszcz, 1);
        gdansk.addDestination(torun, 3);

        bydgoszcz.addDestination(gdansk, 1);
        bydgoszcz.addDestination(torun, 1);
        bydgoszcz.addDestination(warszawa, 4);

        torun.addDestination(gdansk, 3);
        torun.addDestination(bydgoszcz, 1);
        torun.addDestination(warszawa, 1);

        warszawa.addDestination(bydgoszcz, 4);
        warszawa.addDestination(torun, 1);

        cities.addNode(gdansk);
        cities.addNode(bydgoszcz);
        cities.addNode(torun);
        cities.addNode(warszawa);
    }

    @After
    public void tearDown() throws Exception {
        cities = null;
        gdansk = null;
        bydgoszcz = null;
        torun = null;
        warszawa = null;
    }

    @Test
    public void testCalculateShortestPathFromSource() {
        cities = GraphUtil.calculateShortestPathFromSource(cities, gdansk);
        Assert.assertEquals(3, cities.getNodes().stream()
                .filter(city -> city.getName().equals("warszawa"))
                .findFirst()
                .orElse(null)
                .getDistance());

        cities = GraphUtil.calculateShortestPathFromSource(cities, bydgoszcz);
        Assert.assertEquals(2, cities.getNodes().stream()
                .filter(city -> city.getName().equals("warszawa"))
                .findFirst()
                .orElse(null)
                .getDistance());
    }
}