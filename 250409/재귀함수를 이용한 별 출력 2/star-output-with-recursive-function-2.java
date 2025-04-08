import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        printStar(n, n + 1, false);
    }

    public static void printStar(int n, int end, boolean reverse) {
        if(n == end) return;
        if(n == 0) {
            printStar(n + 1, end, true);
            return;
        }
        for(int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        if(reverse) {
            printStar(n + 1, end, true);
        } else {
            printStar(n - 1, end, reverse);
        }
    }
}