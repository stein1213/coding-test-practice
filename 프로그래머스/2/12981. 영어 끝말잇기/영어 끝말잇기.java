import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Map<String, Integer> wordMap = new HashMap<>();
        
        wordMap.put(words[0], 0);
        
        for(int i = 1; i < words.length; i++) {
            
            String beforeWord = words[i-1];
            
            char lastAlphabet = beforeWord.charAt(beforeWord.length()-1);
            
            char firstAlphabet = words[i].charAt(0);
            
            if(!wordMap.containsKey(words[i]) && lastAlphabet == firstAlphabet) {
                
                wordMap.put(words[i], i);
            } else {
                
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
          
        }

        return answer;
    }
}