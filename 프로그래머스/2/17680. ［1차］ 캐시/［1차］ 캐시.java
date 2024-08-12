import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        
        Map<Integer, String> cacheMap = new HashMap<>();
        
        Collection<String> cacheCities = cacheMap.values();
            
        for(int i = 0; i < cities.length; i++) {
            
            String city = cities[i];
            
            Iterator cityItr = cacheCities.iterator();
            
            boolean cityIsApplied = false;
            
            while (cityItr.hasNext()) {
                
                String itrNext = (String)cityItr.next();
                
                if (itrNext.equalsIgnoreCase(city)) {
                    cityIsApplied = true;
                    break;
                }
            }
         
            if(!cityIsApplied) {
                               
                answer = answer + 5;
            } else {
                
                for (int j = i - 1; j >= 0; j--) {
                    
                    if (cities[j].equalsIgnoreCase(city)) {
                        cacheMap.remove(j);
                        answer++;
                        break;
                    }
                }   
            }
            
            cacheMap.put(i, city);
            
            if (cacheMap.size() > cacheSize) {
 
                Iterator keyItr = cacheMap.keySet().iterator();
                
                int minKey = (Integer)keyItr.next();
                
                while (keyItr.hasNext()) {
                    
                    int key = (Integer)keyItr.next();
                    
                    if (minKey > key) {
                        minKey = key;
                    }
                }
                
                cacheMap.remove(minKey);
            }
            
        }
            
        return answer;
    }
}