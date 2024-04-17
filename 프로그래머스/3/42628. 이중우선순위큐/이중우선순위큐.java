import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            if (op.startsWith("I")) {
                min.add(Integer.valueOf(op.substring(2)));
                max.add(Integer.valueOf(op.substring(2)));
            } else if (max.size() == 0 || min.size() == 0) {
                continue;
            } else if (op.charAt(2) == '1') {
                int value = max.poll();
                // PriorityQueue<Integer> min2 = new PriorityQueue<>();
                // for (int i = 1; i < min.size(); i++) {
                //     min2.add(min.poll());
                // }
                // min.poll();
                // min = min2;
                min.remove(value);
            } else {
                int value = min.poll();
                // PriorityQueue<Integer> max2 = new PriorityQueue<>(Collections.reverseOrder());
                // for (int i = 1; i < max.size(); i++) {
                //     max2.add(max.poll());
                // }
                // max.poll();
                // max = max2;
                max.remove(value);
            }
            
        }
        
        if (min.size() > 0) {
            answer[1] = min.poll();
            answer[0] = max.poll();
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}