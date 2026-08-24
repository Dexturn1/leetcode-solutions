class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1); // -1: uncolored, 0: set A, 1: set B

        // Handle disconnected component
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, colors, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[] colors, int[][] graph) {
        
        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == -1) {
                // Color neighbor with the opposite color (1 - color)
                if (!dfs(neighbor, 1 - color, colors, graph)) {
                    return false;
                }
            } else if (colors[neighbor] == color) {
                // Adjacent node has the same color -> not bipartite
                return false;
            }
        }
        return true;
    }
}