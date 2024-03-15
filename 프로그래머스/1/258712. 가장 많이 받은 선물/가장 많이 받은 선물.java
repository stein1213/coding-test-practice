import java.util.Arrays;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] presentList = new int[friends.length][friends.length];
        String[] giveAndTake = new String[2];
        String giver;
        String taker;
        for (int i = 0; i < gifts.length; i++) {
            giveAndTake = gifts[i].split(" ");
            giver = giveAndTake[0];
            taker = giveAndTake[1];
            presentList[Arrays.asList(friends).indexOf(giver)][Arrays.asList(friends).indexOf(taker)] += 1;
        }
       
        int[] answerList = new int[friends.length];
        int[] presentFactor = new int[friends.length];
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                presentFactor[i] += presentList[i][j];
                presentFactor[j] -= presentList[i][j];
            }
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if  (presentList[i][j] > presentList[j][i]) {
                    answerList[i] += 1;
                } else if(presentList[i][j] == presentList[j][i]) {
                    answerList[i] += (presentFactor[i] > presentFactor[j]) ? 1 : 0;
                }
            }
        }
        
         for (int i = 0; i < friends.length; i++) {
             if (answer < answerList[i]) {
                 answer = answerList[i];
             }
         }
        return answer;
    }
}