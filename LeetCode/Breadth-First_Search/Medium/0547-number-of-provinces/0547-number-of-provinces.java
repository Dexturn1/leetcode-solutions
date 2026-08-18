class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean []visited = new boolean[n];

        int numOfprovinces = 0;

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                numOfprovinces++;
            }
        }
        return numOfprovinces;
    }



    public void dfs(int start, int graph[][], boolean[]visited){
        visited[start] = true;

        for(int j = 0; j<graph.length; j++){
            if(graph[start][j] == 1 && !visited[j]){
                dfs(j, graph, visited);
            }
        }
    }


    public void bfs( int start, int graph[][], boolean []visited){
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;

        queue.add(start);

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int neighbor: graph[current]){
                if(graph[current][neighbor] == 1 &&  !visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }

        }

    }
}