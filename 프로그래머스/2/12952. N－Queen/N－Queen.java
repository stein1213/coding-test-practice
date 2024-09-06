class Solution {
    public int solution(int n) {
        
        // x: 행 인덱스, y: 열 인덱스
        // place[y] = x
        int[] place = new int[n];
        
        // x 중복 체크
        boolean[] raw = new boolean[n];
        
        // x y 값 더하기
        boolean[] cross1 = new boolean[n * 2];
        
        // x y 값 뺀 것에 n 더하기
        boolean[] cross2 = new boolean[n * 2];
        
        nQueen(n, 0, place, raw, cross1, cross2);
        
        return count;
        
    }
    
    static int count = 0;
    
    void nQueen(int n, int y, int[] place, boolean[] raw, boolean[] cross1, boolean[] cross2) {
        
        for (int x = 0; x < n; x++) {
            
          if (!raw[x] && !cross1[x + y] && !cross2[x - y + n]) {
            
                place[y] = x;
            
                if (y == n - 1) {
                    
                    count++;
                    return;
                } 
                else {
                    
                    raw[x] = cross1[x + y] = cross2[x - y + n] = true;
                    
                    nQueen(n, y + 1, place, raw, cross1, cross2);
                    
                    raw[x] = cross1[x + y] = cross2[x - y + n] = false;
                } 
            }  
        }       
    }
}