package pkg.solution;

import pkg.location.Location;

import java.util.*;

public class Solution {
    public static class ShortestPath{
        public ShortestPath(Location locationStart, Location locationEnd){
            System.out.println("In total am mers pentru: " + FindKey(locationStart,locationEnd));
        }
    }

    public static int FindKey(Location locationStart, Location locationEnd){
        int sum = 0;
        if(locationStart.getLocationMap().containsKey(locationEnd)) {
            System.out.println("Sunt in " + locationStart.getName() + " si mai am de mers pentru " + locationStart.getLocationMap().get(locationEnd));
            return locationStart.getLocationMap().get(locationEnd);
        }

        else{
            sum += locationStart.getLocationMap().get(getFirstKeyFromMap(locationStart.getLocationMap()))+FindKey(getFirstKeyFromMap(locationStart.getLocationMap()),locationEnd);
            System.out.println("Sunt in: " + locationStart.getName() +
                    " si ma duc spre " + getFirstKeyFromMap(locationStart.getLocationMap()).getName() +
                    " cu distanta de " + locationStart.getLocationMap().get(getFirstKeyFromMap(locationStart.getLocationMap())));
            locationStart.getLocationMap().entrySet().remove(getFirstKeyFromMap(locationStart.getLocationMap()));
            return sum;
        }
    }

    private static Location getFirstKeyFromMap(Map<Location,Integer> map){
        return map.entrySet().iterator().next().getKey();
    }

    public static class Edge
    {
        int source, dest;

        public Edge(int source, int dest)
        {
            this.source = source;
            this.dest = dest;
        }
    }

    public static class Graph
    {
        List<List<Integer>> adjList = null;

        Graph(List<Edge> edges, int N)
        {
            adjList = new ArrayList<>();
            for (int index = 0; index < N; index++) {
                adjList.add(new ArrayList<>());
            }
            for (Edge edge: edges)
            {
                int src = edge.source;
                int dest = edge.dest;

                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }
    }

    public static void recursiveBFS(Graph graph, Queue<Integer> queue, boolean[] discovered)
    {
        if (queue.isEmpty()) {
            return;
        }

        int poll = queue.poll();
        System.out.print(poll + " ");
        for (int u: graph.adjList.get(poll))
        {
            if (!discovered[u])
            {
                discovered[u] = true;
                queue.add(u);
            }
        }

        recursiveBFS(graph, queue, discovered);
    }
}
