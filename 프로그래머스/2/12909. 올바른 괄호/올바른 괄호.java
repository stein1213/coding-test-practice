import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ) {
                stack.push("(");
            } else {
                if (stack.empty()) {
                    answer = false;
                    return answer;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            answer = true;
        } else {
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}