import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        
        List<String> list = new ArrayList<>();
        
        Map<Integer, Integer> tupleMap = new HashMap<>();
        
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '{') {
                
                int startIndex = i + 1;
                while (s.charAt(i) != '}') {
                    i++;
                }
                int endIndex = i;
                
                String tuple = s.substring(startIndex, endIndex);
                
                list.add(tuple);
                
            }
        }
        
        int size = list.size();
        
        StringBuffer longest = new StringBuffer();

        for (int i = 0; i < size; i++) {
                
            int index = 0;
            while (index < list.get(i).length()) {
                    
                String tuple = list.get(i);
                    
                if (tuple.charAt(index) == ',') {
                        
                    int element = Integer.parseInt(longest.toString());
                    tupleMap.put(element, tupleMap.getOrDefault(element, size) - 1);
                    longest = new StringBuffer();
                                    
                } else {
                        longest.append(tuple.charAt(index));
                }
                index++;
            }
            
            int element = Integer.parseInt(longest.toString());
            tupleMap.put(element, tupleMap.getOrDefault(element, size) - 1);
            longest = new StringBuffer();
    
        }
        
        int[] answer = new int[size];
        
        Iterator itr = tupleMap.keySet().iterator();
        
        while (itr.hasNext()) {
            int element = (Integer)itr.next();
            answer[tupleMap.get(element)] = element;
        }
                
        return answer;
    }
}