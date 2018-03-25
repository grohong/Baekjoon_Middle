import java.util.ArrayList;
import java.util.Scanner;

public class 트리의순회 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        ArrayList<Integer> postOrder = new ArrayList<Integer>();

        for (int i=0; i<input; i++) {
            inOrder.add(scanner.nextInt());
        }

        for (int i=0; i<input; i++) {
            postOrder.add(scanner.nextInt());
        }

        ArrayList<Integer> freeOrder = new ArrayList<Integer>();
        solve(freeOrder, inOrder, postOrder);

        for (int i=0; i<freeOrder.size(); i++) {
            System.out.print(""+freeOrder.get(i)+" ");
        }
    }

    public static void solve(ArrayList<Integer> freeOrder, ArrayList<Integer> inOrder, ArrayList<Integer> postOrder) {

        if (postOrder.size() == 0) {
            return;
        }

        int root = postOrder.get(postOrder.size()-1);
        freeOrder.add(root);
        int rootIndex = inOrder.indexOf(root);

        ArrayList<Integer> leftInOrder = new ArrayList<Integer>();
        ArrayList<Integer> rightInOrder = new ArrayList<Integer>();

        ArrayList<Integer> leftPostOrder = new ArrayList<Integer>();
        ArrayList<Integer> rightPostOrder = new ArrayList<Integer>();

        for (int i=0; i<rootIndex; i++) {
            leftInOrder.add(inOrder.get(i));
        }
        for (int i=inOrder.size()-1; i>rootIndex; i--) {
            rightInOrder.add(inOrder.get(i));
        }

        for (int i=0; i<leftInOrder.size(); i++) {
            leftPostOrder.add(postOrder.get(i));
        }
        for (int i=leftInOrder.size(); i<postOrder.size()-1; i++) {
            rightPostOrder.add(postOrder.get(i));
        }

        solve(freeOrder, leftInOrder, leftPostOrder);
        solve(freeOrder, rightInOrder, rightPostOrder);
    }
}
