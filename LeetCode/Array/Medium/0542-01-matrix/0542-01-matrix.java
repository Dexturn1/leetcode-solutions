class Solution {

    static class Node{
            int row;
            int col;
            int dist; 

            Node(int row, int col, int dist){
                this.row = row;
                this.col = col;
                this.dist = dist;
            }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][]visited = new boolean[n][m];
        int [][] distance = new int[n][m];

        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        int []delrow = {-1,0,1,0};
        int []delcol = {0,1,0,-1};

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;

            distance[row][col] = dist;

            for(int i = 0; i< 4; i++){
                int newrow = row + delrow[i];
                int newcol = col + delcol[i];

                if(newrow >= 0 && newrow <n && newcol >= 0 && newcol <m && !visited[newrow][newcol]){
                    visited[newrow][newcol] = true;
                    queue.offer(new Node(newrow,newcol,dist+1));
                }
            }


        }

        return distance;
        }
}