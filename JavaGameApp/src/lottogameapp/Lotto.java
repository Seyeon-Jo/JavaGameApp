package lottogameapp;

import javax.swing.JOptionPane;
import java.util.Random;

public class Lotto {

    private int[] numbers = new int[3];
    private static Random random = new Random();

    public Lotto() {
        for (int i = 0; i < 3; i++) {
            numbers[i] = 1 + random.nextInt(9);
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter a number between 3 and 27:", "Lotto Game", JOptionPane.QUESTION_MESSAGE);
        int userNumber = Integer.parseInt(input);

        if (userNumber < 3 || userNumber > 27) {
            JOptionPane.showMessageDialog(null, "Invalid number! Please choose a number between 3 and 27.");
            return;
        }

        boolean userWins = false;

        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto();
            int sum = 0;
            for (int num : lotto.getNumbers()) {
                sum += num;
            }

            JOptionPane.showMessageDialog(null, "Lotto draw " + (i+1) + ": " + lotto.getNumbers()[0] + ", " + lotto.getNumbers()[1] + ", " + lotto.getNumbers()[2] + "\nSum: " + sum);

            if (sum == userNumber) {
                userWins = true;
                break;
            }
        }

        if (userWins) {
            JOptionPane.showMessageDialog(null, "Congratulations! You win!");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, the computer wins.");
        }
    }
}
