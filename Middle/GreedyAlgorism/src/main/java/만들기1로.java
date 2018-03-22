import java.util.Scanner;

public class 만들기1로 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int[] cach = new int[input+1];

        for (int i=2; i<=input; i++) {
            int compareTemp = cach[i-1]+1;

            if (i%2 == 0) {
                compareTemp = Math.min(cach[i-1], cach[i/2]);
                compareTemp++;
            }

            if (i%3 == 0) {
                compareTemp = Math.min(cach[i-1], cach[i/3]);
                compareTemp++;
            }

            cach[i] = compareTemp;
        }

        System.out.println(cach[input]);
    }
}
