class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for(int i = 0; i<isConnected.length; i++){
            if(visited[i] == false){
                count++;
                bfs(i, isConnected,visited);
            }
        }
        return count;
    }

    public static void bfs(int node, int[][] isConnected, boolean[]visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i = 0; i<isConnected.length; i++){
                if(isConnected[temp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
    
               
            }
        }
    }
}