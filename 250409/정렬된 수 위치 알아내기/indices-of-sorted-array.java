import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Info[] arr = new Info[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Info(i, sc.nextInt());
        }
        // Please write your code here.
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.num != o2.num) {
                return o1.num - o2.num;
            } else {
                return o1.index - o2.index;
            }
        });
        
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[arr[i].index] = i + 1;
        }

        for(int i: res) {
            System.out.print(i + " ");
        }
    }
}

class Info {
    int index;
    int num;

    public Info(int index, int num) {
        this.index = index;
        this.num = num;
    }
}