package programmers.lv3;

import java.util.PriorityQueue;

//https://school.programmers.co.kr/learn/courses/30/lessons/12927
/*
    문제를 제대로 풀지 못함

    내가 풀었던 방식은 이분 탐색을 이용한 풀이를 진행했었는데 부분점수만 나옴
    이분 탐색을 사용한 이유는 works가 2만 이하의 배열이기 때문에 이중 for문을 사용하면 안되면서 최적의 편차를 구하기 위한 방법이 이분탐색이라 생각했음..

    하지만 굳이 이분탐색이 아니라 우선순위 큐에 works의 내림차순으로 만든 하 poll() -> 1 줄이기 0이 아니면 다시 넣는 방법을 이용하면
    n의 크기가 백만이라 O(n)으로 충분히 돌아감..

    훨씬 코드가 간단하고 직관적임
*
**/
public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> o2 - o1);


        for(int work: works) {
            pq.add(work);
        }

        while(n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if(max != 1) {
                pq.add(max - 1);
            }
            n--;
        }

        if(pq.isEmpty()) {
            return 0;
        }

        for(int res: pq) {
            answer += (long) res * res;
        }

        return answer;
    }
}
