import java.util.*;

class Solution {
    public void init(HashMap<String, Integer> buy ,String[] want, int[] number) {
        
        int length = want.length;
        
        for(int i = 0; i < length; i++) {
            
            buy.put(want[i], number[i]);
        }
    
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> buy = new HashMap<>();
        
        for (int i = 0; i <= discount.length-10; i++) {
            init(buy, want, number);
            
            for (int j = i; j < i + 10; j++) {
                
                String key = discount[j];
                if (buy.containsKey(key)) {
                    Integer value = buy.get(key);
                    
                    if (--value == 0) {
                        buy.remove(key);
                    } else {
                        buy.put(key, value);
                    } 
                } else break;
            }
            
            if (buy.isEmpty()) answer++;
        }
        // 해시맵을 사용해서 구매할 물품을 키로, 갯수를 값으로 추가
        // 이중 for문으로 첫번째는 할인품목 전체를, 두번째는 10번째까지 품목을 순회
        // 해시맵에서 물품 조회, 없으면 바로 break, 있으면 해시맵에서 지우기
        // 안쪽for문이끝나면 해시맵의 값 조회, 0이면 answer 1추가, 
        // 다시for 문을시작하면 해시맵 초기화 해야함
        
        return answer;
    }
}