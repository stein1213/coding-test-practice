import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {

        Arrays.sort(targets, (a, b) -> {
            
            return a[1] - b[1];
        });
        
        int answer = 1;

        int e = targets[0][1];
        
        for (int i = 1; i < targets.length; i++) {
    
            if (e <= targets[i][0]) {
                
                answer++;
                e = targets[i][1];
            }
        }
        
        return answer;
        
    }
}