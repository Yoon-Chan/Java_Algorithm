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
            String[] ymd = date.split("-");
            w[i] = new Info(
                ymd[0],
                ymd[1],
                ymd[2],
                day,
                weather
            );
        }

        Arrays.sort(w, (o1, o2) -> {
                if(o1.y != o2.y) {
                    return o1.y.compareTo(o2.y);
                } else if(o1.m != o2.m) {
                    return o1.m.compareTo(o2.m);
                } else {
                    return o1.d.compareTo(o2.d);
                }
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
    String y;
    String m;
    String d;
    String D;
    String W;

    public Info(String y, String m, String d, String D, String W) {
        this.y = y;
        this.m = m;
        this.d = d;
        this.D = D;
        this.W = W;
    }

    public String toInfo() {
        return y + "-" + m +"-" + d + " " + D + " " + W;
    }
}