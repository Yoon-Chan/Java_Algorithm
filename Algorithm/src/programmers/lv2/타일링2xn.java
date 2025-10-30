package programmers.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12900
public class 타일링2xn {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;
        }
        return dp[n];
    }
}
