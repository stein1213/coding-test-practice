import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        List<Integer> list = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            list.add(Integer.valueOf(numbers[i]));
        }
        Integer max = list.stream().mapToInt(x -> x).max().getAsInt();
        Integer min = list.stream().mapToInt(x -> x).min().getAsInt();
        answer = min+ " " + max;
        return answer;
    }
}