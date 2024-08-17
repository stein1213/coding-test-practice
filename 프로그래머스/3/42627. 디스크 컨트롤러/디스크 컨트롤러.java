import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 현재 시각
        int current = 0;
        // 요청~종료까지의 시간의 총합
        int operationTime = 0;
        // jobs의 인덱스값
        int index = 0;
        
        // jobs를 요청시간 순으로 정렬
        Arrays.sort(jobs, (a, b) -> {
            return a[0] - b[0];
        });
        
        // 실행 대기중인 작업 리스트
        List<int[]> list = new ArrayList<>();
        
        while (list.size() != 0 || index < jobs.length) {
            
            // current 기준으로 대기리스트에 작업 추가
            while (index < jobs.length && jobs[index][0] <= current) {
                
                list.add(jobs[index++]);
            }
            
            if (list.size() == 0) {
                current++;
                continue;
            }
            
            // 대기 리스트를 실행시간 기준으로 정렬
            Collections.sort(list, (a, b) -> {
                
                return a[1] - b[1];
            });
            // 실행시간이 가장 짧은 작업 실행
            current += list.get(0)[1];
            
            operationTime += current - list.get(0)[0];
            
            // 완료된 작업 리스트에서 제거
            list.remove(0);
            
        }
        
        return operationTime / jobs.length;
    }
}