import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int correct1 = 0;
        int correct2 = 0;
        int correct3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if (answer1[i % 5] == answer) {
                correct1++;
            }
            
            if (answer2[i % 8] == answer) {
                correct2++;
            }
            
            if (answer3[i % 10] == answer) {
                correct3++;
            }
        }
        
        int max = Math.max(correct1, Math.max(correct2, correct3));
        
        List<Integer> list = new ArrayList<>();
        
        if (max == correct1) {
            list.add(1);
        }
        
        if (max == correct2) {
            list.add(2);
        }
        
        if (max == correct3) {
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}