class Solution {
    public int solution(int k, int[][] dungeons) {

        boolean[] visit = new boolean[dungeons.length];
        
        return explore(0, visit, k, dungeons);   
        
    }
    
    int explore(int count, boolean[] visit, int k, int[][] dungeons) {
        
        int max = count;
        
        for(int i = 0; i < visit.length; i++) {
            
            if (k >= dungeons[i][0] && !visit[i]) {
                
                visit[i] = true;
                
                max = Math.max(max ,explore(count + 1, visit, k - dungeons[i][1], dungeons));
                
                visit[i] = false;
            }
                       
        }
        
        return max;
               
    }
}