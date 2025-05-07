import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int min = GCD(n, m);

        System.out.println( (n * m) / min);
    }

    public static int GCD(int a, int b) {
        if(a % b == 0) return b;
        else return GCD(b, a % b);
    }
}