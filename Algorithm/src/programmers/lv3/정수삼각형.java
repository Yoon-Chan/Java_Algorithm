package programmers.lv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/43105
public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] res = new int[N][N];

        for(int i = 0; i < N; i++) {
            res[N - 1][i] = triangle[N - 1][i];
        }

        for(int i = N - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                res[i][j] = triangle[i][j] + Math.max(res[i + 1][j], res[i + 1][j + 1]);
            }
        }
        return res[0][0];
    }
}
