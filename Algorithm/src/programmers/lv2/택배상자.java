package programmers.lv2;

import java.util.*;

public class 택배상자 {
    Stack<Integer> stk;
    public int solution(int[] order) {
        stk = new Stack<>();

        int answer = 0;

        int start = 1;
        for(int o: order ) {
            if(start == o) {
                start++;
                answer++;
                continue;
            }

            if(start < o) {
                while(start != o) {
                    stk.push(start++);
                }
                start++;
                answer++;
            } else {
                if(stk.peek() == o) {
                    stk.pop();
                    answer++;
                } else break;
            }

        }
        return answer;
    }
}
