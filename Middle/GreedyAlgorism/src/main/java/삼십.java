import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 삼십 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<String> inputList = new ArrayList<String>();

        int temp = 0;
        int zero = 0;
        for (int i=0; i<input.length(); i++) {
            if (Integer.parseInt(String.valueOf(input.charAt(i))) == 0) {
                zero++;
            } else {
                inputList.add(String.valueOf(input.charAt(i)));
                temp += Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        }

        String answer = "-1";
        if ((zero != 0) && (temp%3 == 0)) {
            Collections.sort(inputList);
            Collections.reverse(inputList);

            String ans = "";
            for (int i=0; i<inputList.size(); i++) {
                ans += inputList.get(i);
            }

            for (int i=0; i<zero; i++) {
                ans += "0";
            }

            answer = ans;
        }

        System.out.println(answer);
    }
}
