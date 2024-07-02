package programmers;

import java.util.*;

public class pb04 {

    //모의고사
    //https://school.programmers.co.kr/learn/courses/30/lessons/42840
    class Solution {
        public int[] solution(int[] answers) {

            int[] a = new int[] {1,2,3,4,5};
            int[] b = new int[] {2,1,2,3,2,4,2,5};
            int[] c = new int[] {3,3,1,1,2,2,4,4,5,5};

            List<Integer> answer = new ArrayList<>();

            int[][] person = new int[][] {a, b, c};
            int[] answer_count = new int[3];
            int max = 0;
            for(int i = 0; i < person.length; i++) {
                //맞힌 개수 구하기
                int[] p = person[i];
                int count = 0;
                for(int j = 0; j < answers.length; j++) {
                    if(answers[j] == p[j % p.length]) {
                        count++;
                    }
                }
                answer_count[i] = count;
                if(count > max) {
                    max = count;
                }
            }

            for(int i = 0; i < answer_count.length; i++) {
                if(max == answer_count[i]) answer.add(i+1);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
