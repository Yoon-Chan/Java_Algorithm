package programmers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/68645
public class 삼각달팽이 {
    int[][] dir = new int[][] {
            {1, 0},
            {0, 1},
            {-1, -1}
    };

    int[][] map;

    public int[] solution(int n) {

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        // System.out.println("sum : " + sum);

        map = new int[n][n];

        int startDir = 0;
        int y = 0;
        int x = 0;
        for(int i = 1; i <= sum; i++) {
            // System.out.println("i : " + i + ", y : " + y + ", x : " + x +", map : " + map[y][x]);
            if(isCheck(y, x)) {
                map[y][x] = i;
            }


            int newY = y + dir[startDir][0];
            int newX = x + dir[startDir][1];

            if(isCheck(newY, newX)) {
                y = newY;
                x = newX;
            } else {
                startDir = (startDir + 1) % 3;
                y += dir[startDir][0];
                x += dir[startDir][1];
            }
        }

//         for(int[] row : map) {
//             for(int col: row) {
//                 System.out.print(col + " ");
//             }
//             System.out.println();
//         }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                res.add(map[i][j]);
            }
        }

        int[] answer = new int[res.size()];

        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public boolean isCheck(int y, int x) {
        return y >= 0 && y < map.length && x >= 0 && x < map[0].length && map[y][x] == 0;
    }
}
