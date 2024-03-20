import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i : truck_weights) {
            q1.add(i);
        }
        int answer = 0;
        int sumWeight = 0;
        while (!q1.isEmpty()) {
            if (q2.size() < bridge_length) {
                sumWeight += q1.peek();
            } else {
                sumWeight += q1.peek() - q2.poll();
            }
            
            if (sumWeight > weight) {
                sumWeight -= q1.peek();
                q2.add(0);
                answer++;
                continue;
            } else {
                q2.add(q1.poll());
                answer++;
                continue;
            }
        }
        answer += bridge_length;
        
        
        return answer;
    }
}

// 