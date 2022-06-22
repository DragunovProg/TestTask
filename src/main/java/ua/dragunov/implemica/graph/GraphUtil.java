package ua.dragunov.implemica.graph;

import java.util.*;


/**
 * The Util Class for find the shortest path from given source
 * It is implements through Dijkstra algorithm
 *
 * @author Igor Dragunov
 * @version 1.0
 * */
public class GraphUtil {


    /**
     *  The main method which is implemented dijkstra algorithm
     *
     * @param source - starter  {@code Node}
     * */
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node current = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(current);

            for (Map.Entry<Node, Integer> adjacencyPair : current.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                int edgeWeight = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, current, edgeWeight);
                    unsettledNodes.add(adjacentNode);
                }
            }

            settledNodes.add(current);
        }

        return graph;
    }


    /**
     * The method that finds the minimum value in unsettled nodes
     *
     * @param unsettledNodes
     * @return {@link Node}
     * */
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node: unsettledNodes) {
            if (node.getDistance() < lowestDistance) {
                lowestDistance = node.getDistance();
                lowestDistanceNode = node;
            }
        }

        return lowestDistanceNode;
    }


    /**
     * Method that calculate minimum distance from source node to evaluated node
     *
     * @param evaluatedNode - evaluated node
     * @param source - source node
     * @param edgeWeight - weight of the given node
     *
     * */
    private static void calculateMinimumDistance(Node evaluatedNode, Node source, int edgeWeight) {
        int sourceDistance = source.getDistance();

        if (sourceDistance + edgeWeight < evaluatedNode.getDistance()) {
            evaluatedNode.setDistance(sourceDistance + edgeWeight);
            List<Node> shortestPath = new LinkedList<>(source.getShortestPath());
            shortestPath.add(source);
            evaluatedNode.setShortestPath(shortestPath);
        }
    }

}
