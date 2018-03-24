import java.util.Arrays;
import java.util.Scanner;

public class 배열합치기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstCount = scanner.nextInt();
        int secondCount = scanner.nextInt();

        int[] firstList = new int[firstCount];
        for (int i=0; i<firstCount; i++) {
            firstList[i] = scanner.nextInt();
        }

        int[] secondList = new int[secondCount];
        for (int i=0; i<secondCount; i++) {
            secondList[i] = scanner.nextInt();
        }

        Arrays.sort(firstList);
        Arrays.sort(secondList);

        int firstIndex = 0;
        int secondIndex = 0;

        int[] answerArray = new int[firstList.length + secondList.length];
        int index = 0;
        int temp = firstList.length+secondList.length;
        while (temp != index) {
            if (firstList.length == firstIndex) {
                answerArray[index] = secondList[secondIndex];
                secondIndex++;
            } else if (secondList.length == secondIndex) {
                answerArray[index] = firstList[firstIndex];
                firstIndex++;
            } else if (firstList[firstIndex] > secondList[secondIndex]) {
                answerArray[index] = secondList[secondIndex];
                secondIndex++;
            } else {
                answerArray[index] = firstList[firstIndex];
                firstIndex++;
            }
            index++;
        }

        for (int i=0; i<firstList.length + secondList.length; i++) {
            System.out.print(""+answerArray[i]+" ");
        }
    }
}
