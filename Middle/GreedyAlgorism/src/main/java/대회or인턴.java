import java.util.Scanner;

public class 대회or인턴 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int femaleStudent = scanner.nextInt();
        int maleStudent = scanner.nextInt();
        int intern = scanner.nextInt();

        int answer = 0;
        while (femaleStudent >= 2 && maleStudent >= 1 && femaleStudent+maleStudent >= intern+3) {
            answer += 1;
            femaleStudent -= 2;
            maleStudent -= 1;
        }
        System.out.println(answer);
    }
}
