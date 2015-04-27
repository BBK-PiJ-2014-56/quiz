package quiz.server;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by jimjohn_thornton on 21/04/15.
 */
public class UI implements Serializable {

    private static final long serialVersionUID = 3138L;

    private int currentAnswerNumber = 1;
    private int currentScore = 0;
    public UI(quizImpl quiz) {
        for (QuestionAndAnswer q : quiz.getQuestions()){
            System.out.println(q.getQuestion());
            for (String a : q.getAllAnswers()){
                System.out.println(currentAnswerNumber + ") " + a);
                currentAnswerNumber++;
            }
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            if (q.getAnswer(i)) {
                System.out.println("well done");
                currentScore++;
            }
            else
                System.out.println("incorrect");
            currentAnswerNumber = 1;

        }
        System.out.println("you scored " + currentScore);
    }
}
