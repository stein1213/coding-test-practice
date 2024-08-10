class Solution {
    public int solution(int[][] sizes) {
        int[] answer = {Math.min(sizes[0][0], sizes[0][1]), Math.max(sizes[0][0], sizes[0][1])};
        
        for(int i = 1; i < sizes.length; i++) {
            
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            int max = Math.max(sizes[i][0], sizes[i][1]);
            
            if (min > answer[0]) {
                answer[0] = min;
            }
            
            if (max > answer[1]) {
                answer[1] = max;
            }
        }
        
        
        return answer[0] * answer[1];
    }
}