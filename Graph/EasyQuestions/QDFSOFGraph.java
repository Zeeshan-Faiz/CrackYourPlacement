package Graph.EasyQuestions;

import java.util.ArrayList;

/*
You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th 
vertex from left to right according to the graph.

Example 1:
Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

Output: 0 2 4 3 1
Explanation: 
0 is connected to 2, 3, 1.
1 is connected to 0.
2 is connected to 0 and 4.
3 is connected to 0.
4 is connected to 2.
so starting from 0, it will go to 2 then 4,
and then 3 and 1.
Thus dfs will be 0 2 4 3 1.

Example 2:
Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 0, 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 
*/

public class QDFSOfGraph {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V + 1];
        vis[0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, vis, adj, list);
        return list;
    }

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj,
            ArrayList<Integer> list) {

        // mark and add current node
        vis[node] = true;
        list.add(node);

        // getting neighbour of current node and go depth for each neighbour
        for (Integer neighbour : adj.get(node)) 
        {
            //recurse only if neighbour is not visited
            if (vis[neighbour] == false) {
                dfs(neighbour, vis, adj, list);
            }
        }
    }
}