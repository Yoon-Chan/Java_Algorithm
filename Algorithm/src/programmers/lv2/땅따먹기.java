package programmers.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12913
/*
* 전형적인 dp 문제인 것 같아 바로 적용해서 문제 풀이 완료
* 최대 시간 복잡도가 100_000 * 4 * 3이라 충분히 돌아간다고 판단하고 적용했음.
* **/
public class 땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];

        for(int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 1; k <= 3; k++) {
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][(j +k) % 4]);
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }

        return answer;
    }
}
