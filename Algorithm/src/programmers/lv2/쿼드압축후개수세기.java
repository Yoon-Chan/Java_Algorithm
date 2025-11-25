package programmers.lv2;

public class 쿼드압축후개수세기 {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];

        int size = arr.length;
        dfs(arr, 0, 0, size);

        return answer;
    }

    public void dfs(int[][] arr, int y, int x, int size) {
        if(size == 1) {
            answer[arr[y][x]]++;
            return;
        }

        boolean check = true;
        int start = arr[y][x];
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(start != arr[i][j]) {
                    check = false;
                }
            }
            if(!check) break;
        }

        if(check) {
            answer[start]++;
            return;
        }

        //4방향 확인하기
        int newSize = size / 2;
        dfs(arr, y, x, newSize);
        dfs(arr, y, x + newSize, newSize);
        dfs(arr, y + newSize, x, newSize);
        dfs(arr, y + newSize, x + newSize, newSize);
    }
}
