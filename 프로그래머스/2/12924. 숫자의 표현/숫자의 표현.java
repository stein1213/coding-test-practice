class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            int a = n/i - (i+1) / 2 + 1;
            if (a < 1) break;
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += a + j;
            }
            if(sum == n) {
                answer++;
                System.out.println(i);
            } 
        }
        return answer;
    }
}