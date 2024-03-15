class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        String color = board[h][w];
        for (int i = 0; i < 4; i++) {
            if ((h + dh[i]) < 0 || (w + dw[i]) < 0 || (h + dh[i]) >= n || (w + dw[i]) >= n) continue;
            if (color.equals(board[h + dh[i]][w + dw[i]])) answer++;
        }
        return answer;
    }
}