class Solution {
    public int[] solution(int n) {
     
        int[][] triangle = new int[n][n];
        
        for (int i = 0; i < n; i++) triangle[i] = new int[i + 1];
        
        int index = 0;
        int row = 0;
        int num = 0;
        int p = 0;
        
        while (row < n && triangle[row][index] == 0) {
            
            while(row < (n - 1 - p)) triangle[row++][index] = ++num;
            
            while(index < row - p) triangle[row][index++] = ++num;
            
            while (row >= 0 && triangle[row][index] == 0) triangle[row--][index--] = ++num;
            
            row += 2;
            index += 1;
            p++;
        }
        
        int[] answer = new int[num];
        
        int count = 0;
        
        for (row = 0; row < n; row++) {
            
            for (index = 0; index <= row; index++) {
                
                answer[count] = triangle[row][index];
                count++;
            }
        }
        
        return answer;
    }
}