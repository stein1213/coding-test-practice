import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        int h = 1;
        
        Arrays.sort(citations);
        
        for (int i = n - 1; i >= 0; i--) {
         
            if (citations[i] < h) break; 
            
            h++;
        }
        
        return h - 1;
        
    }
}