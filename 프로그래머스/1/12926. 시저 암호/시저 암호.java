class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] solution = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) + n;
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                if (j > 90) {
                    j -= 26;
                    solution[i] = (char) j;
                } else {solution[i] = (char)j;}
            }
            if (97<=s.charAt(i) && s.charAt(i)<= 122) {
                if (j > 122) {
                    j -= 26;
                    solution[i] = (char) j;
                } else {solution[i] = (char) j;}
            }
            if (s.charAt(i) == ' ') {
                j -= n;
                solution[i] = (char) j;
            }
        }
        answer = new String(solution);
        
        return answer;
    }
}