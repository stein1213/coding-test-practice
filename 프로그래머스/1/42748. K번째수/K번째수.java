import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];     
        
        for (int l = 0; l < answer.length; l++) {
            
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] tmpArr = Arrays.copyOfRange(array, i - 1, j);
            
            Arrays.sort(tmpArr);
            
            answer[l] = tmpArr[k - 1];
        }
        return answer;
    }
}