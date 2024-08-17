import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        List<String> list = new ArrayList<>();
        
        String[] strArr = {"", "A", "E", "I", "O", "U"};
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                for (int k = 0; k <= 5; k++) {
                    for (int l = 0; l <= 5; l++) {
                        for (int m = 0; m <= 5; m++) {
                            
                            String s = strArr[i] + strArr[j] + strArr[k] + strArr[l] + strArr[m];
                            
                            if (!list.contains(s)) list.add(s);

                        }
                    }
                }
            }
        }
        
        Collections.sort(list, (a, b) -> {
            
            int minLength = Math.min(a.length(), b.length());
            
            int index = 0;
            
            while (index < minLength) {
                
                if (a.charAt(index) != b.charAt(index)) return a.charAt(index) - b.charAt(index);
                
                index++;
            }
            
            if (a.length() == minLength) return -1;
            else return 1;
        });      

        return list.indexOf(word) + 1;
    }
}