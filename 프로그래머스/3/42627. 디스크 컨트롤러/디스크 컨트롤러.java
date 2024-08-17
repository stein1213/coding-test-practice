import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        List<int[]> list = new ArrayList<>();
        
        int current = 0;
        
        int operationTime = 0;
        
        int index = 0;
        
        List<int[]> jobList = Arrays.asList(jobs);
        
        Collections.sort(jobList, (a, b) -> {
            return a[0] - b[0];
        });
        
        while (list.size() != 0 || index < jobList.size()) {
            
            while (index < jobList.size() && jobList.get(index)[0] <= current) {
                
                list.add(jobList.get(index++));
            }
            
            if (list.size() == 0) {
                current++;
                continue;
            }
            
            Collections.sort(list, (a, b) -> {
                
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });
            
            current += list.get(0)[1];
            
            operationTime += current - list.get(0)[0];
            
            list.remove(0);
            
        }
        
        answer = operationTime / jobs.length;
        
        return answer;
    }
}