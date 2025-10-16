package programmers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/49994
public class 방문길이 {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int[] start = new int[] { 0, 0 };
        for(String dir: dirs.split("")) {
            int y = start[0];
            int x = start[1];
            if(dir.equals("L")) {
                x -= 1;
            } else if(dir.equals("R")) {
                x += 1;
            } else if(dir.equals("D")) {
                y += 1;
            } else {
                y -= 1;
            }

            if(isCheck(y, x)) {
                set.add(start[0] + ", " + start[1] +":" + y +", " + x);
                set.add(y + ", " + x +":" + start[0] +", " + start[1]);
                start = new int[] {y, x};
            }
        }
        return set.size() / 2;
    }

    public boolean isCheck(int y, int x) {
        return y >= -5 && y <= 5 && x >= -5 && x <= 5;
    }
}
