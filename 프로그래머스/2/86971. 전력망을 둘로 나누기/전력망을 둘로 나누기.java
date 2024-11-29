import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] wires) {

        int[] devide = new int[n + 1];
        
        int answer = n;
        
        for (int[] wire : wires) {
            
            devide[wire[0]] = 1;
            devide[wire[1]] = 2;
            
            while (checkZero(devide)) {
               for (int j = 0; j < wires.length; j++) {
                
                    if (wires[j] == wire) continue;
                
                    int wire1 = wires[j][0];
                
                    int wire2 = wires[j][1];
                
                    if (devide[wire1] == 1 || devide[wire2] == 1) devide[wire1] = devide[wire2] = 1;
                    else if (devide[wire1] == 2 || devide[wire2] == 2) devide[wire1] = devide[wire2] = 2; 
                }    
            }
            
            int count = 0;
            for (int i = 1; i < devide.length; i++) {
                if(devide[i] == 1) count++;
                devide[i] = 0;
            } 
            
            answer = Math.min(answer, Math.abs(n - count * 2));
            
        }
        
        return answer;
    }
    
    boolean checkZero(int[] devide) {

        for (int i = 1; i < devide.length; i++) if(devide[i] == 0) return true;
        
        return false;
    }
}