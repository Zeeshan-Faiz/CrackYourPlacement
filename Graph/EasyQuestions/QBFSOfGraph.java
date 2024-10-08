package Graph.EasyQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal 
of the graph starting from the 0th vertex, from left to right according to the input graph. Also, 
you should only take nodes directly or indirectly connected from Node 0 in consideration.

Example 1:
Input:
V = 5, E = 4
adj = {{1,2,3},{},{4},{},{}}

Output: 
0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3. After this 2 to 4, thus bfs will be
0 1 2 3 4.

Example 2:
Input:
V = 3, E = 2
adj = {{1,2},{},{}}

Output: 
0 1 2
Explanation:
0 is connected to 1 , 2.
so starting from 0, it will go to 1 then 2,
thus bfs will be 0 1 2. 
*/

public class QBFSOfGraph {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // add first node in the queue and mark it visited
        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) 
        {
            Integer node = queue.poll();
            bfs.add(node);

            // check for all neighbors to this current node and add in the queue
            for (Integer neighbor : adj.get(node)) {
                if (vis[neighbor] == false) {
                    vis[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return bfs;
    }
}