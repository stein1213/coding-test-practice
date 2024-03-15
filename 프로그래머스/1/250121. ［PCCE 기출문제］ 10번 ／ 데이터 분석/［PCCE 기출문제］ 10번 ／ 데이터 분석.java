class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        String[] columnList = {"code", "date", "maximum", "remain"};
        int extIndex = 0;
        int sortIndex = 0;
        for (int i = 0; i < 4; i++) {
            if (columnList[i].equals(ext)) extIndex = i;
            if (columnList[i].equals(sort_by)) sortIndex = i;
        }
        
        int length = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][extIndex] < val_ext) {
                length++;
            }
        }
        
        int[][] answer = new int[length][4];
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][extIndex] < val_ext) {
                answer[count] = data[i];
                count++;
            }
        }
        
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int a = answer[j][sortIndex];
                int b = answer[j+1][sortIndex];
                if (a > b) {
                    int[] tmp;
                    tmp = answer[j];
                    answer[j] = answer[j+1];
                    answer[j+1] = tmp;
                } 
            }
        }
        return answer;
    }
}