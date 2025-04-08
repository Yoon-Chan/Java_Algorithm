import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = new int[n/2 + 1];
        int startIndex = 0;
        // Please write your code here.
        for(int i = 0; i < arr.length; i += 2) {
            int[] copy = Arrays.copyOfRange(arr, 0, i + 1);
            Arrays.sort(copy);
            res[startIndex++] = copy[i / 2];
        } 
        
        for(int i : res) {
            System.out.print(i +" ");
        }
    }
}