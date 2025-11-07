package programmers.lv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/12979
public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        for(int station: stations) {
            if(station - w > start) {
                int diff = ((station - w) - start);
                answer += Math.ceil((diff) / (double)(2*w + 1));
            }
            start = station + w + 1;
        }

        if(start <= n) {
            int diff = n - start + 1;
            answer += Math.ceil((diff) / (double)(2*w + 1));
        }

        return answer;
    }
}
