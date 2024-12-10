import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int length = elements.length;
        int sum = 0;
        
        for(int i = 1; i <= length; i++) {
            for(int j = 0; j<length;j++) {
                for(int k = 0; k < i; k++) {
                    sum += elements[(j+k) % length];  
                }
                set.add(sum);
                sum = 0;
            }
        }
        
        return set.size();   
    }
}