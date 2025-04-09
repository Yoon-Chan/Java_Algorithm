import java.util.*;

public class Main {
    static int[][] knightMapInfo;
    static int[][] trapMap;
    static Knight[] Knights;
    static int[][] direction = new int[][] {
        { -1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public static void main(String[] args) {
        // Please write your code here.
        int answer = 0;
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int N = sc.nextInt();
        int Q = sc.nextInt();

        //-1은 벽
        knightMapInfo = new int[L + 2][L + 2];
        trapMap = new int[L + 2][L + 2];
        Knights = new Knight[N + 1];
        int[] hp = new int[N + 1];

        for(int i = 0; i < (L + 2); i++) {
            if(i == 0 || i == L + 1) {
                Arrays.fill(knightMapInfo[i], -1);
                Arrays.fill(trapMap[i], -1);
                continue;
            }

            for(int j = 0; j < L + 2; j++) {
                if(j == 0 || j == L + 1) {
                    knightMapInfo[i][j] = -1;
                    trapMap[i][j] = -1;
                }
            }
        }

        for(int i = 1; i <= L; i++) {
            for(int j = 1; j <= L; j++) {
                int type = sc.nextInt();
                if(type == 2) {
                    knightMapInfo[i][j] = -1;
                } else if(type == 1) {
                    trapMap[i][j] = 1;
                }
            }
        }

        // for(int i = 0; i < L + 2; i++) {
        //     for(int j = 0; j < L + 2; j++) {
        //         System.out.print(trapMap[i][j] +" ");
        //     }
        //     System.out.println();
        // }

        //나이트의 정보
        for(int i = 1; i <= N; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            int k = sc.nextInt();

            Knights[i] = new Knight(i, new int[]{r, c}, h, w, k);
            hp[i] = k;
            for(int row = r; row < r + h; row++) {
                for(int col = c; col < c + w; col++) {
                    knightMapInfo[row][col] = i;
                }
            }
        }

        // for(int i = 0; i < L + 2; i++) {
        //     for(int j = 0; j < L + 2; j++) {
        //         System.out.print(knightMapInfo[i][j] +" ");
        //     }
        //     System.out.println();
        // }

        //명령문 시작
        for(int i = 0; i < Q; i++){
            int knightIndex = sc.nextInt();
            int dir = sc.nextInt();
            
            Knight selectedKnight = Knights[knightIndex];
            if(selectedKnight.k <= 0) continue;

            List<Knight> moveKnight = new ArrayList<>();
            if(isMove(selectedKnight, direction[dir], moveKnight)) {
                for(Knight k: moveKnight) {
                    //기존 맵에 있는 정보 0으로 초기화
                    for(int row = k.leftTop[0]; row < k.leftTop[0] + k.h; row++ ) {
                        for(int col = k.leftTop[1]; col < k.leftTop[1] + k.w; col++) {
                            knightMapInfo[row][col] = 0;
                        }
                    }
                }

                for(Knight k: moveKnight) {
                    //움직인 기사 위치 변경
                    Knights[k.index].leftTop = k.moveTopLeft(direction[dir]);
                    //기존 맵에 있는 정보 자기 인덱스로 변경
                    int damage = 0;
                    for(int row = Knights[k.index].leftTop[0]; row < Knights[k.index].leftTop[0] + Knights[k.index].h; row++ ) {
                        for(int col = Knights[k.index].leftTop[1]; col < Knights[k.index].leftTop[1] + Knights[k.index].w; col++) {
                            knightMapInfo[row][col] = Knights[k.index].index;
                            if(trapMap[row][col] == 1) {
                                damage++;
                            }
                        }
                    }
                    
                    if(Knights[k.index].index != selectedKnight.index) {
                        if(Knights[k.index].k < damage) {
                            Knights[k.index].k = 0;
                        } else {
                            Knights[k.index].k -= damage;
                        }
                        
                    }

                    //죽으면 다시 0으로 변경
                    if(Knights[k.index].k <= 0) {
                        for(int row = Knights[k.index].leftTop[0]; row < Knights[k.index].leftTop[0] + Knights[k.index].h; row++ ) {
                            for(int col = Knights[k.index].leftTop[1]; col < Knights[k.index].leftTop[1] + Knights[k.index].w; col++) {
                                knightMapInfo[row][col] = 0;
                            }
                        }
                    }
                }

                // //변경된 결과 출력
                // System.out.println("\n " + i + "번 명령문");
                // for(int r = 0; r < L + 2; r++) {
                //     for(int c = 0; c < L + 2; c++) {
                //         System.out.print(knightMapInfo[r][c] +" ");
                //     }
                //     System.out.println();
                // }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(Knights[i].k != 0) {
                answer += (hp[i] - Knights[i].k);
            }
        }
        System.out.println(answer);
    }

    public static boolean isMove(Knight knight, int[] dir, List<Knight> moveKnight) {
        Queue<Knight> queue = new LinkedList<>();
        queue.add(knight);
        moveKnight.add(knight);

        while(!queue.isEmpty()) {
            Knight k = queue.poll();
            // System.out.println("isAvailable Start");
            if(k.isAvailableMove(knightMapInfo, dir)) {
                // System.out.println("isAvailable : " + k.leftTop[0] +", " + k.leftTop[1]);
                int[] getMoveLeftTop = k.moveTopLeft(dir);
                for(int row = getMoveLeftTop[0]; row < getMoveLeftTop[0] + k.h; row++) {
                    for(int col = getMoveLeftTop[1]; col < getMoveLeftTop[1] + k.w; col++) {
                        if(knightMapInfo[row][col] != 0 && knightMapInfo[row][col] != k.index) {
                            queue.add(Knights[knightMapInfo[row][col]]);
                            moveKnight.add(Knights[knightMapInfo[row][col]]);
                        }
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }
}

class Knight {
    int index;
    int[] leftTop;
    int h;
    int w;
    int k;

    public Knight(int index, int[] leftTop, int h, int w, int k) {
        this.index = index;
        this.leftTop = leftTop;
        this.h = h;
        this.w = w;
        this.k = k;
    }

    public boolean isAvailableMove(int[][] maps, int[] dir) {
        for(int i = this.leftTop[0]; i < this.leftTop[0] + this.h; i++) {
            for(int j = leftTop[1]; j < leftTop[1] + w; j++) {
                int moveRow = i + dir[0];
                int moveCol = j + dir[1];
                if(maps[moveRow][moveCol] == -1) return false;
            }
        }
        return true;
    }

    public int[] moveTopLeft(int[] dir) {
        return new int[] { leftTop[0] + dir[0], leftTop[1] + dir[1] };
    }
}