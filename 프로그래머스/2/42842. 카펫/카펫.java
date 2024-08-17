class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
//         wy + 2 = width;
//         ly + 2 = length;
        
//         wy * ly = yellow;
        
//         2 * (width + ly) == 2 * (length + wy) == brown;
//         wy + ly + 2 == brown / 2
        
        int ly = (int)Math.sqrt(yellow);
        
        while (ly > 0) {
            
            if (yellow % ly == 0) {
                int wy = yellow / ly;
                
                if (wy + ly + 2 == brown / 2) {
                    
                     answer[0] = wy + 2;
                    answer[1] = ly + 2;
                    
                    return answer;
                }
            }
            ly--;
        }
      return answer;  
    }
        
}
