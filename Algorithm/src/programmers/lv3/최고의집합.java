package programmers.lv3;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12938
public class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = {};

        if(s/n < 1) return new int[] { -1 };

        answer = new int[n];
        Arrays.fill(answer, s/n);
        int res = s % n;
        for(int i = n - 1; i >= 0; i--) {
            if(res == 0) break;
            answer[i]++;
            res--;
        }

        return answer;
    }
}
