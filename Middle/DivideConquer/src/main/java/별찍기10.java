import java.util.Scanner;

public class 별찍기10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int[][] answer = starblock(input);
        for (int i=0; i<input; i++) {
            System.out.println("\n");
            for (int j=0; j<input; j++) {
                if (answer[i][j] == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }

    public static int[][] starblock(int size) {
        int[][] block = new int[size][size];
        if (size == 3) {
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if ((i==1) && (j==1)) {
                        block[i][j]=0;
                    } else {
                        block[i][j]=1;
                    }
                }
            }
            return block;
        }

        int tempSize = size/3;
        int[][] tempBlock = starblock(tempSize);
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if ((i==1) && (j==1)) {
                    for (int a=i*tempSize; a<i*tempSize+tempSize; a++) {
                        for (int b=j*tempSize; b<j*tempSize + tempSize; b++) {
                            block[a][b] = 0;
                        }
                    }
                } else {
                    int indexI = 0;
                    for (int a=i*tempSize; a<i*tempSize+tempSize; a++) {
                        int indexJ = 0;
                        for (int b = j*tempSize; b < j*tempSize + tempSize; b++) {
                            block[a][b] = tempBlock[indexI][indexJ];
                            indexJ++;
                        }
                        indexI++;
                    }
                }
            }
        }

        return block;
    }
}
