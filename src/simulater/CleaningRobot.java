package simulater;

public class CleaningRobot {
    public static void main(String[] args) {
        CleaningRobot cleaningRobot = new CleaningRobot();
        int[][] board = {
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
//        int[][] board = {
//                {0, 0, 0, 0, 0},
//                {0, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1},
//                {0, 0, 0, 0, 0}
//        };
        int k = 20;
        cleaningRobot.solution(board, k);
    }

    public void solution(int[][] board, int k) {
        // 방향을 정의할 배열, answer 세팅
        int[] robot = {0, 0};
        int[][] directionArray = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int second = 0;
        int boardSize = board.length;
        int x = 0;
        int y = 1;

        // 방향에 따라 돌아감
        while(second < k) {
            int tempX = robot[x] + directionArray[direction][x];
            int tempY = robot[y] + directionArray[direction][y];

            if(tempX < 0 || tempX >= boardSize) {
                direction = (direction + 1) % 4;
                second++;
                continue;
            }

            if(tempY < 0 || tempY >= boardSize) {
                direction = (direction + 1) % 4;
                second++;
                continue;
            }

            int wall = board[tempX][tempY];
            if(wall == 1) {
                direction = (direction + 1) % 4;
                second++;
                continue;
            }

            robot[x] = tempX;
            robot[y] = tempY;
            second++;
        }
        // answer 출력
        for(int i=0; i<2; i++) {
            System.out.print(robot[i] + " ");
        }
    }
}
