import java.io.IOException;
import java.util.Scanner;

public class 종이의개수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[][] array = new int[input][input];

        for (int i=0; i<input; i++) {
            for (int j=0; j<input; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int[] answer = new int[3];

        solve(array, answer, 0,0, input);


        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }

    public static Boolean paper(int[][] array, int x, int y, int size) {
        int paperInt = array[x][y];

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (paperInt != array[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void solve(int[][] array, int[] count, int x, int y, int size) {
        if (paper(array, x, y, size)) {
            if (array[x][y] == -1) {
                count[0]++;
            } else if (array[x][y] == 0) {
                count[1]++;
            } else {
                count[2]++;
            }
            return;
        }

        int nextSize = size/3;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                solve(array, count, x+i*nextSize, y+j*nextSize, nextSize);
            }
        }
    }
}
