package Graph.MediumQuestions;

import java.util.List;

/*
Given an undirected graph and an integer M. The task is to determine if the graph can be colored 
with at most M colors such that no two adjacent vertices of the graph are colored with the same 
color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is 
possible to colour vertices and 0 otherwise.
*/

public class MColoringProblem {

    public static boolean graphColoring(List<Integer>[] G, int[] color, int M) {

        int n = G.length;
        if (solve(0, G, color, n, M) == true)
            return true;
        return false;
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {

        //if all nodes are colored return true
        if (node == n)
            return true;

        for (int i = 1; i <= m; i++) 
        {
            if (isSafe(node, G, color, n, i)) 
            {
                color[node] = i; //color the node and call for the next node
                if (solve(node + 1, G, color, n, m) == true)
                    return true;
                color[node] = 0; //backtrack and remove the color from node
            }
        }
        return false;
    }

    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        for (int neighbor : G[node]) {
            if (color[neighbor] == col)//if neighbor's color is same as the color we want to apply to current node, return false
                return false;
        }
        return true;
    }
}