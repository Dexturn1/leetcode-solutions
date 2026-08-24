class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }


        for(int i = 0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int [] path = new int[numCourses];
        int [] vis = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(vis[i] == 0){
                if(dfsCheck(i, adj, vis, path))
                    return false;
            }
        }

        return true;  
    }
    boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] path){

        vis[node] = 1;
        path[node] = 1;

        for(int neighbor: adj.get(node)){
            
            if(vis[neighbor] == 0){

                if(dfsCheck(neighbor, adj, vis, path)){
                    return true;
                }
            }else if(path[neighbor] == 1){
                return true;
            }

        }

        path[node] = 0;
        return false;

    }

}