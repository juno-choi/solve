package simulater;

import java.util.Arrays;

public class LostDog {
    public static void main(String[] args) {
        LostDog lostDog = new LostDog();
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        };

        lostDog.solution(board);
    }

    public void solution(int[][] board) {
        // 현수와 강아지 세팅
        int[] person = getIndex(board, 2);
        int[] dog = getIndex(board, 3);

        int boardSize = board.length;

        // 방향 세팅
        int[][] personDirectionArray = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] dogDirectionArray = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
        int personDirection = 0;
        int dogDirection = 0;

        // 현수와 강아지가 최대 10,000분 동안 서로를 찾아 다닌다
        int minute = 0;
        while (minute <= 10000) {
            // 현수의 x, y를 구한다
            int tempPersonY = person[0] + personDirectionArray[personDirection][0];
            int tempPersonX = person[1] + personDirectionArray[personDirection][1];
            // 강아지의 x, y를 구한다
            int tempDogY = dog[0] + dogDirectionArray[dogDirection][0];
            int tempDogX = dog[1] + dogDirectionArray[dogDirection][1];

            boolean isPersonDirection = false;
            boolean isDogDirection = false;


            // 벽인지 우선 판단
            if(tempPersonX >= boardSize || tempPersonY >= boardSize || tempPersonX < 0 || tempPersonY < 0 || board[tempPersonY][tempPersonX] == 1) {
                personDirection = (personDirection + 1) % 4;
                isPersonDirection = true;
            }
            if(tempDogX >= boardSize || tempDogY >= boardSize || tempDogX < 0 || tempDogY < 0 || board[tempDogY][tempDogX] == 1) {
                dogDirection = (dogDirection + 1) % 4;
                isDogDirection = true;
            }

            // 현수와 강아지가 서로를 찾은지 확인
            if(tempPersonX == tempDogX && tempPersonY == tempDogY) {
                break;
            }

            // 아니라면 이동
            if(!isPersonDirection) {
                person[0] = tempPersonY;
                person[1] = tempPersonX;
            }

            if(!isDogDirection) {
                dog[0] = tempDogY;
                dog[1] = tempDogX;
            }
            minute++;
        }

        System.out.println(minute > 10000 ? 0 : minute);
    }

    private int[] getIndex(int[][] board, int target) {
        int x = -1;
        int y = 0;
        for(int[] row : board) {
            for(int i = 0; i < row.length; i++) {
                if(row[i] == target) {
                    x = i;
                    break;
                }
            }
            if(x >= 0) {
                return new int[] {x, y};
            }
            y++;
        }

        return new int[] {x, y};
    }
}
