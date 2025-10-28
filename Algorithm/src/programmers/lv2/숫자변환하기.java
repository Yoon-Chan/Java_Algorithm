package programmers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/154538
public class 숫자변환하기 {
    public int solution(int x, int y, int n) {

        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[y] = 0;

        for(int i = y; i >=0; i--) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            if(i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }

            if(i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }

            if(i - n >= 0) {
                dp[i - n] = Math.min(dp[i - n], dp[i] + 1);
            }
        }

        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }
}
