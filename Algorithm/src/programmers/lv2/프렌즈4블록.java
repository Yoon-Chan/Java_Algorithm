package programmers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/17679
public class 프렌즈4블록 {
    String[][] maps;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        maps = new String[m][n];

        for(int i = 0; i < m ; i++) {
            String[] col = board[i].split("");
            for(int j = 0; j < n; j++) {
                maps[i][j] = col[j];
            }
        }

        while(true) {
            List<int[]> pos = remove(m, n);

            if(pos.isEmpty()) {
                break;
            }

            maps = createMap(m, n, pos);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(maps[i][j].equals(" ")) answer++;
            }
        }

        return answer;
    }

    public List<int[]> remove(int m, int n) {
        List<int[]> removePos = new ArrayList<>();

        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                String value = maps[i][j];
                if(value.equals(" ")) continue;
                if(value.equals(maps[i + 1][j]) && value.equals(maps[i][j + 1]) && value.equals(maps[i + 1][j + 1])) removePos.add(new int[] {i , j});
            }
        }
        return removePos;
    }

    public String[][] createMap(int m, int n, List<int[]> pos) {
        String[][] mapClone = maps.clone();

        for(int[] p: pos) {
            int row = p[0];
            int col = p[1];

            mapClone[row][col] = " ";
            mapClone[row + 1][col] = " ";
            mapClone[row][col + 1] = " ";
            mapClone[row + 1][col + 1] = " ";
        }

        for(int j = 0; j < n; j++ ) {
            for(int i = m - 1; i >= 0; i--) {
                if(!mapClone[i][j].equals(" ")) continue;

                int nextRow = i - 1;
                while(nextRow >= 0) {
                    if(!mapClone[nextRow][j].equals(" ")) {
                        // System.out.println("find " + nextRow + " " + mapClone[nextRow][j]);
                        break;
                    }

                    nextRow--;
                }
                // System.out.println("j : " + j + ", i : " + i + ", nextRow : " + nextRow);
                if(nextRow == -1) break;

                mapClone[i][j] = mapClone[nextRow][j];
                mapClone[nextRow][j] = " ";
            }
        }
        return mapClone;
    }
}
