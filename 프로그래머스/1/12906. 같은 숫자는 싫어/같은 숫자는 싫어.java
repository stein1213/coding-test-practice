import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] tmp = new int[arr.length];
        
        int count = 0;
        
        tmp[0] = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            
            if (arr[i - 1] != arr[i]) {
                tmp[++count] = arr[i];
            }
        }
        
        int[] answer = new int[count + 1];
        
        for(int i = 0; i <= count; i++) {
            
            answer[i] = tmp[i];
        }

        return answer;
    }
}