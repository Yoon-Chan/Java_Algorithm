package programmers.lv3;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12987
public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int startA = A.length - 1;
        int startB = B.length - 1;

        for(int i = startA; i >= 0; i--) {
            if(B[startB] > A[i]) {
                answer++;
                startB--;
            }
        }
        return answer;
    }
}
