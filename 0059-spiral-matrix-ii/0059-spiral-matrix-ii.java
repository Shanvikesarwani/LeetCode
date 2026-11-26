class Solution {
    public int[][] generateMatrix(int n) {

        int ans[][] = new int[n][n];

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

        int num = 1;

        while(startRow <= endRow && startCol <= endCol) {

            // Left to Right
            for(int i = startCol; i <= endCol; i++) {
                ans[startRow][i] = num++;
            }
            startRow++;

            // Top to Bottom
            for(int i = startRow; i <= endRow; i++) {
                ans[i][endCol] = num++;
            }
            endCol--;

            // Right to Left
            if(startRow <= endRow) {
                for(int i = endCol; i >= startCol; i--) {
                    ans[endRow][i] = num++;
                }
                endRow--;
            }

            // Bottom to Top
            if(startCol <= endCol) {
                for(int i = endRow; i >= startRow; i--) {
                    ans[i][startCol] = num++;
                }
                startCol++;
            }
        }

        return ans;
    }
}