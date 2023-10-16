import java.util.PriorityQueue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int rowLen = board.length, colLen = board[0].length, target = rowLen * colLen, row, column, point;
        boolean[] visited = new boolean[rowLen * colLen + 1];
        PriorityQueue<int[]> boardPrioQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boardPrioQueue.offer(new int[] {0, 1});
        visited[1] = true;

        while (!boardPrioQueue.isEmpty()) {
            int[] stepPos = boardPrioQueue.poll();
            int step = stepPos[0] / 1000 + 1;
            for (int i = 1; i <= 6; i++) {
                point = stepPos[1] + i;
                if (visited[point]) continue;
                visited[point] = true;

                row = rowLen - (point - 1) / colLen - 1;
                column = (point - 1) % colLen;
                if ((rowLen - row - 1) % 2 == 1) column = colLen - column - 1;
                int ladder = board[row][column];
                
                if (ladder > 0 && ladder <= target) point = ladder;
                if (point == target) return step;
                boardPrioQueue.offer(new int[] {step * 1000 + 500 - point, point});
            }
        }
        return -1;
    }
}
