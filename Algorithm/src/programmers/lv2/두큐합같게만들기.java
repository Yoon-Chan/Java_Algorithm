package programmers.lv2;

import java.util.*;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        long sum1 = 0;
        long sum2 = 0;
        int len = queue1.length + queue2.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int q: queue1) {
            sum1 += q;
            q1.add(q);
        }

        for(int q: queue2) {
            sum2 += q;
            q2.add(q);
        }

        long target = (sum1 + sum2) / 2;
        int startIndex = 0;

        while(startIndex <= 2* len) {
            if(sum1 == 0) {
                int value = q2.poll();
                q1.add(value);
                sum1 += value;
                startIndex++;
                continue;
            }


            if(sum1 == target) {
                answer = startIndex;
                break;
            } else if(sum1 < target) {
                int value = q2.poll();
                q1.add(value);
                sum1 += value;
            } else {
                int value = q1.poll();
                q2.add(value);
                sum1 -= value;
            }

            startIndex++;
        }

        return answer;
    }
}
