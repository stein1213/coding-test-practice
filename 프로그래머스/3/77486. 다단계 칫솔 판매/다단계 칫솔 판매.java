import java.util.*;

class Solution {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> referMap = new HashMap<>();
        
        Map<String, Integer> profitMap = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            referMap.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            
            String myName = seller[i];
            
            int profit = amount[i] * 100;
            
             while(!myName.equals("-") && profit != 0){
                
                
                profitMap.put(myName, profitMap.getOrDefault(myName, 0) + profit - profit / 10);
                      
                profit = profit / 10;
                 
                myName = referMap.get(myName);
                
            }          
            
        }
        
        for (int i = 0; i < enroll.length; i++) {
              answer[i] = profitMap.getOrDefault(enroll[i], 0);
            
        }
        return answer;
    }
}