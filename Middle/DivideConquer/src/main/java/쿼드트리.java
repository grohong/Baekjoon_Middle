import java.util.Scanner;

public class 쿼드트리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int[][] pictureInfo = new int[input][input];
        for (int i=0; i<input; i++) {
            String temp = scanner.next();
            for (int j=0; j<input; j++) {
                pictureInfo[i][j] = Integer.parseInt(""+temp.charAt(j)+"");
            }
        }

        StringBuffer answer = new StringBuffer();
        solve(pictureInfo, 0, 0, input, answer);

        System.out.println(answer);
    }

    public static void solve(int[][] pictureInfo, int startRow, int startColumn, int size, StringBuffer answer) {
        if (picture(pictureInfo, startRow, startColumn, size)) {
            if (size != 1) {
                answer.append(pictureInfo[startRow][startColumn]);
            } else {
                answer.append(pictureInfo[startRow][startColumn]);
                return;
            }
        } else {
            size /= 2;
            answer.append("(");
            for (int i=0; i<2; i++) {
                for (int j=0; j<2; j++) {
                    solve(pictureInfo, startRow+(i*size), startColumn+(j*size), size, answer);
                }
            }
            answer.append(")");
        }
    }

    public static Boolean picture(int[][] pictureInfo, int startRow, int startColumn, int size) {
        int forCompare = pictureInfo[startRow][startColumn];

        for (int i=startRow; i<(startRow+size); i++) {
            for (int j=startColumn; j<(startColumn+size); j++) {
                if (forCompare != pictureInfo[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
