import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sangGunCardNumber = scanner.nextInt();
        int[] sangGunCard = new int[sangGunCardNumber];

        for (int i=0; i<sangGunCardNumber; i++) {
            sangGunCard[i] = scanner.nextInt();
        }
        Arrays.sort(sangGunCard);

        int cardNumber = scanner.nextInt();
        int[] card = new int[cardNumber];

        for (int i=0; i<cardNumber; i++) {
            card[i] = scanner.nextInt();
        }

        StringBuffer answer = new StringBuffer();
        for (int i=0; i<cardNumber; i++) {
            if (search(sangGunCard, card[i])) {
                answer.append("1 ");
            } else {
                answer.append("0 ");
            }
        }

        System.out.println(answer);
    }

    public static Boolean search(int[] list, int number) {
        int start = 0;
        int finish = list.length;
        int tempFinish = finish-1;

        while (start <= tempFinish) {
            int middle = (start+tempFinish)/2;

            if (number == list[middle]) {
                return true;
            } else if (number < list[middle]) {
                tempFinish = middle-1;
            } else  {
                start = middle+1;
            }
        }

        return false;
    }
}
