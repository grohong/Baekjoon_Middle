import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 롤러코스터 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int column = scanner.nextInt();

        int[][] metrix = new int[row][column];

        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                metrix[i][j] = scanner.nextInt();
            }
        }

        String answer = "";
        int minimum = 1000;
        int minimumRow = 0;
        int minimumColumn = 0;

        if (row%2 == 1) {
            for (int i=0; i<row; i++) {
                for (int j=0; j<column-1; j++) {
                    if (i%2 == 0) {
                        answer += "R";
                    } else {
                        answer += "L";
                    }
                }
                answer += "D";
            }
        } else if (column%2 == 1) {
            for (int i=0; i<column; i++) {
                for (int j=0; j<row-1; j++) {
                    if (i%2 == 0) {
                        answer += "D";
                    } else {
                        answer += "U";
                    }
                }
                answer += "R";
            }
        } else {
            ArrayList<String> start = new ArrayList<String>();
            ArrayList<String> finish = new ArrayList<String>();

            for (int i=1; i<=row; i++) {
                for (int j=1; j<=column; j++) {
                    if ((i%2 == 1 && j%2 == 0) && minimum > metrix[i-1][j-1]) {
                        minimum = metrix[i-1][j-1];
                        minimumRow = i;
                        minimumColumn = j;
                    } else if ((i%2 == 0 && j%2 == 1) && minimum > metrix[i-1][j-1]) {
                        minimum = metrix[i-1][j-1];
                        minimumRow = i;
                        minimumColumn = j;
                    }
                }
            }


            for (int i = 1; i < minimumRow-1; i += 2) {

                if (i % 2 == 1) {
                    for (int j = 0; j < column - 1; j++) {
                        start.add("R");
                    }
                    start.add("D");
                    for (int j = 0; j < column - 1; j++) {
                        start.add("L");
                    }
                    start.add("D");
                }
            }

            for (int i = row; i > minimumRow; i -= 2) {

                if (i % 2 == 0) {
                    for (int j = 0; j < column - 1; j++) {
                        finish.add("R");
                    }
                    finish.add("D");
                    for (int j = 0; j < column - 1; j++) {
                        finish.add("L");
                    }
                    finish.add("D");
                }
            }

            for (int i = 1; i < minimumColumn - 1; i += 2) {

                start.add("D");
                start.add("R");
                start.add("U");
                start.add("R");
            }

            for (int i = minimumColumn; i > minimumColumn - 1; i -= 2) {

                finish.add("D");
                finish.add("R");
                finish.add("U");
                finish.add("R");
            }

            if (minimumColumn%2 == 0) {
                start.add("D");
                start.add("R");
            } else {
                start.add("R");
                start.add("D");
            }

            Collections.reverse(finish);
            for (int i = 0; i < start.size(); i++) {
                answer += start.get(i);
            }

            for (int i = 0; i < finish.size(); i++) {
                answer += finish.get(i);
            }
        }

        System.out.println(answer);
    }
}
