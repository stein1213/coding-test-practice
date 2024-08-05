import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int length = priorities.length;
        
        int count = 0;
        
        int target = priorities[location];
        
        // 대기 큐에서 최댓값만 나갈수 있음 
        // 최댓값이 젤 앞에 오기까지 다른값들은 다시 큐에 넣음
        // 찾고자 하는 값을 어떻게 구분할 것인가?
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < length; i++) {
            
            que.offer(priorities[i]);
        }
        
        int max = 9;
        
        while(!que.isEmpty() && max > 0) {
            
            Queue<Integer> copyQue = new LinkedList<>(que);
            
            Iterator<Integer> iterator = copyQue.iterator();
            
            while (iterator.hasNext()) {
                int tmp = iterator.next();
                
                if (tmp == max) {
                    
                    while (que.peek() < tmp) {
                        que.offer(que.poll());
                        location--;
                        if (location < 0) {
                            location = length - 1;
                        }
                    }
                    
                    que.poll();
                    length--;
                    count++;

                    if (target == tmp && location == 0) {
                        return count;
                    }
                    
                   location--;
                
                    if (location < 0) {
                        location = length - 1;
                    } 
                }    
            }
            
            if (que.size() == copyQue.size()) {
               max--;
            } 
        }
        
        return count;
    }
}