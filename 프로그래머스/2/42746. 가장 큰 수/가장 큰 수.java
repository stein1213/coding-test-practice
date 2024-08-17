import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
       for (int number : numbers) {
           
           int length = Integer.toString(number).length();
           
           int key = number / (int)(Math.pow(10, length - 1));
           
           List<Integer> list = map.getOrDefault(key, new ArrayList<Integer>());
           
           list.add(number);
           
           map.put(key, list);
       }
        
        Set<Integer> keySet = map.keySet();
        
        Iterator itr = keySet.iterator();
        
        while(itr.hasNext()) {
            
            int key = (Integer)itr.next();
            
            List<Integer> list = map.get(key);
            
            Collections.sort(list, new MyComparator());
            
            map.put(key, list);
        }
        
        for(int i = 9; i >= 0; i--) {
            
            if (!keySet.contains(i)) continue;
            
            if (i == 0 && answer.length() == 0) {
                answer.append(0);
                break;
            }
            
            for(int a : map.get(i)) {
                
                answer.append(a);
            }
        }
        
        return answer.toString();
        
    }
    
    class MyComparator implements Comparator<Integer> {
        
        @Override
        public int compare(Integer x, Integer y) {
            
            String sx = Integer.toString(x);
            String sy = Integer.toString(y);
            
            int a = Integer.parseInt(sx + sy);
            int b = Integer.parseInt(sy + sx);
            
            return b - a;
            
//             int lengthDifference = sx.length() - sy.length();
            
//             if (lengthDifference > 0) {
                
//                 for(int i = 0; i <= lengthDifference; i = i + sy.length()) {
                    
//                     int tmp = Integer.parseInt(sx.substring(i, sy.length() + i));
                    
//                     if (tmp != y) return y - tmp;
//                 }
                
//                 return -1;
//             } else if (lengthDifference < 0) {
                
//                 for(int i = 0; i <= lengthDifference; i = i + sx.length()) {
                    
//                     int tmp = Integer.parseInt(sy.substring(i, sx.length() + i));
                    
//                     if (tmp != x) return tmp - x;
//                 }
                
//                 return 1;
//             } else return y - x;
            
            // 1211 121 56 5651
        }
    }
}