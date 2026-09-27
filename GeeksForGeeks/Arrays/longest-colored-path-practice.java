import java.util.*;

class Solution {
    private int maxValidPath = 0;

    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        if (n == 0) return 0;

        maxValidPath = 0;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // maxR[u]: max pure Red path starting at u going down into u's subtree
        // maxB[u]: max pure Blue path starting at u going down into u's subtree
        int[] maxR = new int[n];
        int[] maxB = new int[n];

        // Pass 1: Bottom-up DP
        dfs1(0, -1, s, adj, maxR, maxB);

        // totalR[u]: max pure Red path starting at u in ALL directions
        // totalB[u]: max pure Blue path starting at u in ALL directions
        int[] totalR = new int[n];
        int[] totalB = new int[n];

        // Pass 2: Top-down (Rerooting) DP