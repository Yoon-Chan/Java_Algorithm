import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Info[] w = new Info[n];
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            // Please write your code here.
            w[i] = new Info(
                date,
                day,
                weather
            );
        }

        Arrays.sort(w, (o1, o2) -> {
            return o1.date.compareTo(o2.date);
        });
        
        for(int i = 0; i < n; i++){
            if(w[i].W.equals("Rain")) {
                System.out.println(w[i].toInfo());
                break;
            }
        }
    }
}

class Info {
    String date;
    String D;
    String W;

    public Info(String date, String D, String W) {
        this.date = date;
        this.D = D;
        this.W = W;
    }

    public String toInfo() {
        return date + " " + D + " " + W;
    }
}