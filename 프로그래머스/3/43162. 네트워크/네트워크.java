import java.util.*;

class Solution {
    public void dfs(int n, int[][] computers, Integer idx, List<Integer> list) {
        if (!list.contains(idx)) {
            return;
        }
        list.remove(idx);
        for (int i = 0; i < n; i++) {
            if (computers[idx-1][i] == 1) {
                dfs(n, computers, i+1, list);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        while (list.size() > 0) {
            dfs(n, computers, list.get(0), list);
            answer++;
        }
        return answer;
    }
}