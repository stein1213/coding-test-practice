import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        
        List<Integer> list = new ArrayList<>();
        
        for(int a : numbers) {
            list.add(a);
        }
        
        Collections.sort(list, new MyComparator());
        
        for(int a : list) {
            
            if (a == 0 && answer.length() == 0) {
                answer.append(0);
                break;
            }
            answer.append(a);
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
            
        }
    }
}