class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Build reversed graph and calculate out-degrees
        for (int u = 0; u < n; u++) {
            outDegree[u] = graph[u].length;
            for (int v : graph[u]) {
                reverseGraph.get(v).add(u); // edge v -> u
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Start from terminal nodes (out-degree == 0)
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] isSafe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            isSafe[node] = true;

            for (int prev : reverseGraph.get(node)) {
                outDegree[prev]--;
                if (outDegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        // Collect safe nodes in sorted order
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                result.add(i);
            }
        }

        return result;
    }
}