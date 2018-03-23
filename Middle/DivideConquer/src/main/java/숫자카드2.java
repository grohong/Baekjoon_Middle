import java.util.ArrayList;
import java.util.Scanner;

public class 숫자카드2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sangGunInput = scanner.nextInt();
        ArrayList<Integer> sangGunCard = new ArrayList<Integer>();
        ArrayList<Integer> cardCount = new ArrayList<Integer>();
        for (int i=0; i<sangGunInput; i++) {
            int tempInput = scanner.nextInt();
            if (sangGunCard.contains(tempInput)) {
                int cardIndex = sangGunCard.indexOf(tempInput);
                cardCount.set(cardIndex, cardCount.get(cardIndex)+1);
            } else {
                sangGunCard.add(tempInput);
                cardCount.add(1);
            }
        }

        int input = scanner.nextInt();
        ArrayList<Integer> card = new ArrayList<Integer>();

        for (int i=0; i<input; i++) {
            card.add(scanner.nextInt());
        }

        StringBuffer answer = new StringBuffer();
        for (int i=0; i<card.size(); i++) {
            if (sangGunCard.contains(card.get(i))) {
                answer.append(""+cardCount.get(sangGunCard.indexOf(card.get(i)))+" ");
            } else {
                answer.append("0 ");
            }
        }

        System.out.println(answer);
    }
}
