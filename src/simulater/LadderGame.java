package simulater;


public class LadderGame {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        int[][] array = {
                {1, 3, 5},
                {1, 3, 6},
                {2, 4}
        };
//        int[][] array = {
//                {1, 3},
//                {2, 4},
//                {1, 4}
//        };

        int k = 7;

        ladderGame.solution(array, k);
    }

    public void solution(int[][] array, int k) {
        // answer 초기값 세팅
        char[] answer = new char[k];
        for(int i=0; i<k; i++){
            answer[i] = (char) ('A' + i);
        }
        // array를 돌려가며 answer 자리 이동
        for(int i=0; i<array.length; i++) {
            int[] level = array[i];
            for(int j=0; j< level.length; j++) {
                char temp;
                temp = answer[level[j]-1];
                answer[level[j]-1] = answer[level[j]];
                answer[level[j]] = temp;
            }
        }

        // answer 출력
        for(int i=0; i<k; i++){
            System.out.print(answer[i] + " ");
        }

    }
}
