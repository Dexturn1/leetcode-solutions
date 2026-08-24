class Solution {
    Deque<Integer> st = new ArrayDeque<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsCheck(i, graph, visited, path, check);
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(check[i] )
                list.add(i);
        }

        return list;
    }

    public boolean dfsCheck(int node, int[][] graph,
                            boolean[] visited, boolean[] path, boolean[] safe) {

        visited[node] = true;
        path[node] = true;

        for (int neighbor : graph[node]) {

            // Node is already in current DFS path → cycle
            if (path[neighbor])
                return true;

            // Explore unvisited neighbor
            if (!visited[neighbor]) {
                if (dfsCheck(neighbor, graph, visited, path, safe))
                    return true;
            }
        }

        // DFS finished for this node
        path[node] = false;
        // Node is safe
       safe[node] = true;
        return false;
    }
}