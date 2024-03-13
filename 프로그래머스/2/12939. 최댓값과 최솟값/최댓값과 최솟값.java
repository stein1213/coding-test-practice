import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        List<Integer> list = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            list.add(Integer.valueOf(numbers[i]));
        }
        int max = list.stream().mapToInt(x -> x).max().getAsInt();
        int min = list.stream().mapToInt(x -> x).min().getAsInt();
        answer = min + " " + max;
        return answer;
    }
}