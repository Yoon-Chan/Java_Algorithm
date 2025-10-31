package programmers.lv3;

import java.util.PriorityQueue;

//https://school.programmers.co.kr/learn/courses/30/lessons/42884
public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }
        );
        for (int[] route : routes) {
            pq.add(route);
        }

        while (!pq.isEmpty()) {
            int end = pq.peek()[1];
            while (!pq.isEmpty() && pq.peek()[0] <= end) {
                int[] route = pq.poll();
                // System.out.println(answer + " " + end + " " + route[0] + " " + route[1]);
            }
            answer++;
            // int[] route = pq.poll();
            // System.out.println(route[0] + " " + route[1]);
        }


        return answer;
    }
}
