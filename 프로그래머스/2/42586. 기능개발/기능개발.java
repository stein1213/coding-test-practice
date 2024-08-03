import java.util.ArrayList;

import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 매 반복마다 진행상황을 업뎃
        // 업뎃 후 제일 앞의 값이 100 이상이면 제거
        // 값이 제거될 때 연속한 100 이상 값이 같이 제거
        // 한번에 제거되는 값의 수를 answer에 담아서 리턴
        
        List<Integer> completeList = new ArrayList<>();
        
        int idx = 0;
        
        while(idx < progresses.length) {
            
            for(int i = idx; i < progresses.length; i++) {
                
                progresses[i] += speeds[i];
            }
            
            int count = 0;
            
            while (idx < progresses.length && progresses[idx] >= 100) {
                
                idx++;
                count++;
            }
            
            if (count > 0) {
                
                completeList.add(count);
            }
        }
        
        int[] answer = new int[completeList.size()];
        
        for(int i = 0; i < completeList.size(); i++) {
            
            answer[i] = completeList.get(i);
        }
        
        return answer;
    }
}