package Graph.MediumQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
There are n cities connected by some number of flights. You are given an array flights where 
flights[i] = [fromi, toi, pricei] indicates that there is a flight from city from to city toi 
with cost price. You are also given three integers src, dst, and k, return the cheapest price from 
src to dst with at most k stops. If there is no such route, return -1.

Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
*/

public class Q787CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // create adjacency list to form a graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // Create a queue which stores {stops, {node, dist}}
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));// add source with 0 cost

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }
        dist[src] = 0;// source distance to itself has 0 cost

        while (!queue.isEmpty()) 
        {
            Tuple it = queue.peek();
            queue.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // We stop the process as soon as the limit for the stops reaches.
            if (stops > K)
                continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW;
                    queue.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }
        if (dist[dst] == (int) (1e9))
            return -1;
        return dist[dst];
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Tuple {
        int first, second, third;

        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}