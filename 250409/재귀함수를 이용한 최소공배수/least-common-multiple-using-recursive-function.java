import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int a = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int gcd = GCD(a, arr[i]);
            a = (a * arr[i]) / gcd;
        }
        
        System.out.println(a);
    }

    public static int GCD(int a, int b) {
        if(a % b == 0 ) return b;
        else return GCD(b, a % b);
    }
}