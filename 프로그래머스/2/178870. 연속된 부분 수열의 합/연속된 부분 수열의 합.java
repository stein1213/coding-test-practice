class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int sum = 0;

        int end = 0;       
        
        for (int i = 0; i < sequence.length; i++) {
            
            if (sequence[i] < k) end = i;
            else if (sequence[i] == k) return new int[]{i, i};
            else break;
        }
        
        for (int str = end; str >= 0; str--) {
                    
            sum += sequence[str];
            
            if (sum > k) sum -= sequence[end--];
            
            else if (sum == k) {

                if (sequence[str] == sequence[end]) {
                    
                    while (str > 0 && sequence[str] == sequence[end]) {
                        
                        str--;
                        end--;
                    }
                    
                    if (str == 0) return new int[] {str, end};
                    else return new int[] {str + 1, end + 1};
                    
                } else {
                    
                    return new int[]{str, end};
                }
            }
        }
        
        return new int[2];

    }
}