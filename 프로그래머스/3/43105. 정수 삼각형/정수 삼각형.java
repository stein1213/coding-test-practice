class Solution {
    public int solution(int[][] triangle) {
        
        int height = triangle.length;
        int sum[] = new int[height];
        sum[0] = triangle[0][0];
        
        for (int i = 1; i < height; i++) {
            for (int j = i; j >= 0; j--) {
                
                if (j == i) sum[j] = sum[j - 1] + triangle[i][j];
                else if (j == 0) sum[j] += triangle[i][j];
                else sum[j] = Math.max(sum[j], sum[j - 1]) + triangle[i][j]; 
            }     
        }
        
        int answer = sum[0];
        
        for (int i = 1; i < height; i++) {
            
            answer = Math.max(answer, sum[i]);
        }
        
        return answer;
    }
}