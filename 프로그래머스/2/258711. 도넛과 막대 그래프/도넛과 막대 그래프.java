import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
           
        int point = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        Map<Integer, Integer> strMap = new HashMap<>();
        
        Map<Integer, Integer> destMap = new HashMap<>();
        
        for(int[] edge : edges) {
            
            strMap.put(edge[0], strMap.getOrDefault(edge[0], 0) + 1);
            
            destMap.put(edge[1], destMap.getOrDefault(edge[1], 0) + 1);
            
        }
        
        Iterator itr = strMap.keySet().iterator();
        
        List<Integer> list = new ArrayList<>();
        
        int pointNum = destMap.keySet().size();
        
        while (itr.hasNext()) {
            
            int str = (Integer)itr.next();
            
            int count = strMap.get(str);
            
            if (count > 2) point = str;
            else if (count == 2) list.add(str);
            
            if (!destMap.containsKey(str)) pointNum++;
        }
        
        if (point == 0) {
            
            itr = list.iterator();
            
            while(itr.hasNext()) {
                
                int i = (Integer)itr.next();
                
                if (!destMap.containsKey(i)) {
                    
                    point = i;
                    
                    itr.remove();
                }
            }
        }
        
        eight = list.size();
        
        stick = pointNum - strMap.keySet().size();
        
        donut = strMap.get(point) - eight - stick;
        
        return new int[] {point, donut, stick, eight};
           
        // 막대 갯수 : 쏘지 않는 정점 수
        // 8자 갯수 : 2개쏨 + 2개받음 정점 수
        // 도넛 : 그 외?
        // 외부정점 : 2개이상 쏘기만 하는 정점
    }
}