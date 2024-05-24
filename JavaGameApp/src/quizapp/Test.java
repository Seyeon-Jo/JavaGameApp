package quizapp;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {
    private int correctAnswers = 0;
    private int totalQuestions = 5;
    
    private String[] questions = {
        "Which programming tool do we use for Java?",
        "What is the naming convention for variable names?",
        "What was the topic of the lab 1?",
        "What is the keyword that is used to define class-level members (fields or methods) that are associated with the class itself, rather than with instances (objects) of the class?",
        "What is the keyword that the method does not return any value?"
    };

    private String[][] options = {
        {"Eclipse", "NetBeans", "VSCode", "JDeveloper"},
        {"Uppercase", "CamelCase", "Lowercase", "Abbreviation"},
        {"Selling", "Calculation", "Purchase", "Game"},
        {"public", "private", "this", "static"},
        {"void", "int", "boolean", "null"}
    };

    private int[] answers = {
        0, 2, 1, 3, 0
    };

    public void simulateQuestion(int index) {
        String question = questions[index];
        String[] opts = options[index];
        String message = question + "\n";
        for(int i = 0; i < opts.length; i++) {
            message += (i + 1) + ". " + opts[i] + "\n";
        }
        String response = JOptionPane.showInputDialog(null, message, "Question", JOptionPane.QUESTION_MESSAGE);
        int chosenAnswer = Integer.parseInt(response) - 1;
        if(checkAnswer(index, chosenAnswer)) {
            correctAnswers++;
            JOptionPane.showMessageDialog(null, generateMessage(true));
        } else {
            JOptionPane.showMessageDialog(null, generateMessage(false) + "\nThe correct answer is: " + options[index][answers[index]]);
        }
    }

    public boolean checkAnswer(int questionIndex, int answer) {
        return answers[questionIndex] == answer;
    }

    public String generateMessage(boolean correct) {
        Random random = new Random();
        if(correct) {
            switch(random.nextInt(4)) {
                case 0: return "Excellent!";
                case 1: return "Good!";
                case 2: return "Keep up the good work!";
                case 3: return "Nice work!";
            }
        } else {
            switch(random.nextInt(4)) {
                case 0: return "No. Please try again.";
                case 1: return "Wrong. Try once more.";
                case 2: return "Don't give up!";
                case 3: return "No. Keep trying..";
            }
        }
        return ""; 
    }

    public void inputAnswer() {
        for(int i = 0; i < totalQuestions; i++) {
            simulateQuestion(i);
        }
        double percentage = (double) correctAnswers / totalQuestions * 100;
        JOptionPane.showMessageDialog(null, "Correct Answers: " + correctAnswers + "\nIncorrect Answers: " + (totalQuestions - correctAnswers) + "\nPercentage: " + percentage + "%");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.inputAnswer();
    }
}