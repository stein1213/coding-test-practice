import java.util.Arrays;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int n = minerals.length / 5 + 1;
        
        int[][] works = new int[n][3];
        
        int index = 0;
        
        int pick = picks[0] + picks[1] + picks[2];
        
        for(int i = 0; i < n; i++) {
            int dia = 0;
            int iron = 0;
            int stone = 0;
            for (int j = 0; j < 5; j++) {
                
                if (index >= minerals.length || index >= pick * 5) break;
                
                if (minerals[index].equals("diamond")) dia++;
                else if (minerals[index].equals("iron")) iron++;
                else stone++;
                
                index++;
            }
            works[i][0] = dia;
            works[i][1] = iron;
            works[i][2] = stone;
            
        }
        
        Arrays.sort(works, (a, b) -> {
            if (a[0] > b[0]) return -1;
            else if(a[0] < b[0]) return 1;
            else {
                if (a[1] > b[1]) return -1;
                else if (a[1] < b[1]) return 1;
                else {
                    if (a[2] >= b[2]) return -1;
                    else return 1;
                }
            }
        });
        
        int answer = 0;
        
        index = 0;
        
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (index >= works.length) break;
                if (i == 0) {
                    answer += works[index][0] + works[index][1] + works[index][2];
                } else if (i == 1) {
                    answer += works[index][0] * 5 + works[index][1] + works[index][2];
                } else {
                    answer += works[index][0] * 25 + works[index][1] * 5 + works[index][2];
                }
                
                index++;
            }
        }
        
        return answer;
        
    }
}