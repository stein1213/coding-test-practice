class Solution {
    
    int answer;
    boolean[] used;
    
    public int solution(String begin, String target, String[] words) {
     
        answer = words.length;
        used = new boolean[words.length];
        
        boolean isExist = false;
        for(String word : words) {
            if(word.equals(target)) {
                isExist = true;
                break;
            } 
        }
        if(!isExist) return 0;
        
        func(begin, target, words, 0);
        
        
        
        return answer;
    }
    
    void func(String begin,String target, String[] words, int count) {
        
        
        
        if (target.equals(begin)) {
                if (answer > count) answer = count;
                return;
            }

        for(int i = 0; i < words.length; i++) {
            if(used[i]) continue;
            
            int diff = 0;
            for(int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
                if (diff > 1) break;
                
            }
            
            if (diff == 1) {
                used[i] = true;
                func(words[i], target, words, count + 1);
                used[i] = false;
                    
            }
            
                
            
        }
        
        
    }
}