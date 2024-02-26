class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time = 0;
        int bandageStack = 0;
        loopOut:
        while (time <= attacks[attacks.length-1][0]) {
            for (int i = 0; i < attacks.length; i++) {
                if (time == attacks[i][0]) {
                    answer -= attacks[i][1];
                    bandageStack = 0;
                    if (answer <= 0) return -1;
                    time++;
                    continue loopOut;
                }
            }
            answer += bandage[1];
            bandageStack++;
            if (bandageStack == bandage[0]) {
                answer += bandage[2];
                bandageStack = 0;
                } 
            if (answer > health) {
                answer = health;
                }
            time++;
        }
        return answer;
    }
}