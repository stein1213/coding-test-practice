class Solution {
    
    static int count0 = 0;
    static int count1 = 0;
    
    public int[] solution(int[][] arr) {
        comp(arr);
        
        return new int[] {count0, count1};
    }
    
    void comp(int[][] arr) {
        
        int n = arr.length;
        
        if (n == 1) {
            if (arr[0][0] == 0) count0++;
            else count1++;
            
        } else {
            
            int num = arr[0][0];
            
            boolean check = true;
            
            for (int[] a : arr) {
                for(int b : a) {
                    
                    if (b != num) {
                        check = false;
                        break;
                    }
                }
            }
            
            if (check) {
                if (num == 0) count0++;
                else count1++;
                return;
            }
            
            int[][] arr1 = new int[n / 2][n / 2];
            int[][] arr2 = new int[n / 2][n / 2];
            int[][] arr3 = new int[n / 2][n / 2];
            int[][] arr4 = new int[n / 2][n / 2];
            
            for (int i = 0; i < n; i++) {
                
                for (int j = 0; j < n; j++) {
                    
                    if (i < n / 2) {
                        
                        if (j < n / 2) arr1[i][j] = arr[i][j];
                        else arr2[i][j - n / 2] = arr[i][j];
                    } else {
                        
                        if (j < n / 2) arr3[i - n / 2][j] = arr[i][j];
                        else arr4[i - n / 2][j - n / 2] = arr[i][j];
                    }
                }
            }
            
            comp(arr1);
            comp(arr2);
            comp(arr3);
            comp(arr4);
            
        }     
    }
}