import java.util.Scanner;

public class 행렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();
        int width = scanner.nextInt();

        int[][] a = new int[height][width];
        int[][] b = new int[height][width];

        for (int i=0; i<height; i++) {
            String horizontal = scanner.next();
            for (int j=0; j<width; j++) {
                a[i][j] = Integer.parseInt(String.valueOf(horizontal.charAt(j)));
            }
        }

        for (int i=0; i<height; i++) {
            String horizontal = scanner.next();
            for (int j=0; j<width; j++) {
                b[i][j] = Integer.parseInt(String.valueOf(horizontal.charAt(j)));
            }
        }

        int answer = 0;
        for (int i=0; i<height-2; i++) {
            for (int j=0; j<width-2; j++) {
                if (a[i][j] != b[i][j]) {
                    turnMetrix(a, i, j);
                    answer++;
                }
            }
        }

        if (sameMetrix(a, b)) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static void turnMetrix(int[][] inputMetix, int horizontal, int vertical) {
        for (int i=horizontal; i<horizontal+3; i++) {
            for (int j=vertical; j<vertical+3; j++) {
                if (inputMetix[i][j] == 1) {
                    inputMetix[i][j] = 0;
                } else {
                    inputMetix[i][j] = 1;
                }
            }
        }
    }

    public static boolean sameMetrix(int[][] a, int [][] b) {
        boolean result = true;

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    result = false;
                }
            }
        }

        return result;
    }
}
