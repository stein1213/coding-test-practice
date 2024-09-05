import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
                
        hanoi(1, 2, 3, n);
        
        int[][] answer = new int[list.size()][2];
        
        for (int i = 0; i < list.size(); i++) {
            
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    void hanoi(int start, int via, int end, int n) {
        
        if (n > 1) {
            
            hanoi(start, end, via, n - 1);
            
            list.add(new int[] {start, end});
            
            hanoi(via, start, end, n - 1);
            
        } else {
            
            list.add(new int[] {start, end});
        }
    }
}