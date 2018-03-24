import java.util.Scanner;

public class 하노이탑 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tapCount = scanner.nextInt();

        int answer = 1;
        for (int i=0; i<tapCount; i++) {
            answer *= 2;
        }
        answer -= 1;
        System.out.println(answer);

        StringBuffer move = new StringBuffer();
        solve(tapCount, 1, 3, move);
        System.out.println(move);
    }

    public static void solve(int tapCount, int x, int y, StringBuffer move) {
        if (tapCount == 0) return;

        solve(tapCount-1, x, 6-(x+y), move);
        move.append(x + " " + y + "\n");
        solve(tapCount-1, 6-(x+y), y, move);
    }
}
