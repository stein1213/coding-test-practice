import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i : scoville) {
            pQ.offer(i);
        }
        while (pQ.peek() < K) {
            if (pQ.size() < 2) {
                answer = -1;
                break;
            }
            int min = pQ.poll();
            int min2 = pQ.poll();
           
            pQ.add(min + 2 * min2);
            answer++;
        }
        return answer;
    }
}