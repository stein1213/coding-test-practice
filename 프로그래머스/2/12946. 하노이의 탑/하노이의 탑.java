import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
                
        set(1, 3, 2, n);
        
        int[][] answer = new int[list.size()][2];
        
        for (int i = 0; i < list.size(); i++) {
            
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    void set(int start, int end, int via, int n) {
        
        if (n > 1) {
            
            set(start, via, end, n - 1);
            
            list.add(new int[] {start, end});
            
            set(via, end, start, n - 1);
            
        } else {
            
            list.add(new int[] {start, end});
        }
    }
}