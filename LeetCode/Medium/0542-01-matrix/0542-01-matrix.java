class Node{
    int row;
    int col;
    int dist;

    Node(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}


class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean [][]visited = new boolean[n][m];
        int [][]dist = new int[n][m];


        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    q.offer(new Node(i, j, 0));
                }
            }
        }
        
        int [] delRow = {-1, 1, 0, 0};
        int [] delCol = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int currRow = q.peek().row;
            int currCol = q.peek().col;
            int currDist = q.peek().dist;
            q.poll();

            dist[currRow][currCol] = currDist;

            for(int i = 0; i<4; i++){
                int newRow = currRow + delRow[i];
                int newCol = currCol + delCol[i];
                if(newRow >=0 && newRow < n && newCol >=0 && newCol <m && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    q.add(new Node(newRow, newCol,currDist+1));
                }

            }

        } 

        return dist;
    }
}