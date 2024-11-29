class Solution {
    public int solution(int[] arr) {
        
        int[] primeNum = new int[100];
        
        int index = 0;
        
        primeNum[index++] = 2;
        
        for (int i = 3; i <= 100; i++) {
            
            for (int j = 0; j < index; j++) {
                if (i % primeNum[j] == 0) continue;
            }
            
            primeNum[index++] = i;
        }
        
        int[] expArr = new int[index];
        
        int answer = 1;
        
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < index; j++) {
                
                int count = 0;
        
                while (arr[i] % primeNum[j] == 0) {
                    arr[i] /= primeNum[j];
                    count++;
                }
                
                expArr[j] = Math.max(expArr[j], count);     
            }

        }
        
        for (int i = 0; i < index; i++) {
            
            answer *= Math.pow(primeNum[i], expArr[i]);
        }

        return answer;
    }    
}