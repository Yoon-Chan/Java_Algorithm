package programmers.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/17687
public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";


        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(sb.toString().length() <= 1000*100) {
            String value = Integer.toString(start, n);
            sb.append(value.toUpperCase());
            start++;
        }

        // for(int i = 0; i < 100; i++) {
        //     System.out.println(sb.charAt(i) + " ");
        // }
        int cnt = 0;
        while(cnt < t) {
            answer += sb.charAt((p-1) + cnt * m);
            cnt++;
        }
        return answer;
    }
}
