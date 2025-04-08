import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] s = new Student[n];
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            s[i] = new Student(i + 1, height, weight);
        }
        // Please write your code here.
        Arrays.sort(s, (o1, o2) -> {
            if(o1.h != o2.h) {
                return o1.h - o2.h;
            } else {
                return o2.w - o1.w;
            }
        });

        for(Student std: s) {
            System.out.println(std.toString());
        }
    }
}

class Student {
    int index;
    int h;
    int w;

    public Student(int index,int h, int w) {
        this.index = index;
        this.h = h;
        this.w = w;
    }

    public String toString() {
        return h + " " + w + " " + index;
    }
}