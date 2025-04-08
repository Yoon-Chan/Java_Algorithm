import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (o1, o2) -> o1.d - o2.d
        );
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            pq.add(new Point(i + 1, points[i][0], points[i][1]));
        }
        // Please write your code here.
        while(!pq.isEmpty()) {
            Point res = pq.poll();
            System.out.println(res.index);
        }
    }
}

class Point {
    int index;
    int x;
    int y;
    int d;

    public Point(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
        d = Math.abs(x) + Math.abs(y);
    }
}