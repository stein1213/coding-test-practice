class Solution {
    public String solution(int n, int t, int m, int p) {
        
        int num = 0;
     
        int count = 0;
        
        StringBuilder sb = new StringBuilder();
        
        StringBuilder cur = new StringBuilder();
        
        StringBuilder answer = new StringBuilder(t);
        
        while(answer.length() < t) {
            
           while (sb.length() < m) {
            
                do {
                    int tmp = num % n;
                    
                    if (n > 10) {
                        
                        switch(tmp) {
                                  
                            case 10 : cur.append("A"); break;
                            case 11 : cur.append("B"); break;
                            case 12 : cur.append("C"); break;
                            case 13 : cur.append("D"); break;
                            case 14 : cur.append("E"); break;
                            case 15 : cur.append("F"); break; 
                            default : cur.append(num % n);
                        }
                    } else cur.append(num % n); 
                    
                    num /= n;
                }
                while (num > 0);
            
                cur.reverse();
            
                sb.append(cur);
            
                cur.delete(0, cur.length());
            
                num = ++count;
            }
            
            String str = sb.substring(0, m);
            
            sb.delete(0, m);
            
            answer.append(str.charAt(p - 1));
        }
        
        return answer.toString();
    }
}