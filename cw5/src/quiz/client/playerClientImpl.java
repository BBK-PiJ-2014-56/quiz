package quiz.client;

import quiz.server.QuestionAndAnswer;
import quiz.server.*;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public class playerClientImpl implements playerClient, Serializable{

    private static final long serialVersionUID = 3133L;

    private ArrayList<quizImpl> quizList;

    public static void main(String[] args) {
        playerClientImpl game = new playerClientImpl();
        game.startGame();
    }

    @Override
    public void startGame() {
        try {

            System.out.println("enter player name");
            Scanner sc = new Scanner(System.in);
            String playerName = sc.next();
            player p = new playerImpl(playerName);

            System.out.println("choose what quiz you would like to play " + playerName);

            Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            quizServer impl = (quizServer) myRegistry.lookup("myquiz");

            quizList = impl.getQuizList();

            for (int i = 1; i<=quizList.size(); i++) {
                System.out.println(i + ") " + quizList.get(i - 1).getQuizName());
            }
            int quizChoice = sc.nextInt();
            int currentScore = playQuiz(quizChoice);
            if (currentScore>quizList.get(quizChoice-1).getHighScore()) {
                quizList.get(quizChoice-1).newHighScore(p.getPlayerName(), currentScore);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public int playQuiz(int ID) {
        int currentAnswerNumber = 1;
        int currentScore = 0;
        List <QuestionAndAnswer> questions = quizList.get(ID-1).getQuestions();
        for (QuestionAndAnswer q : questions){
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
        return currentScore;
    }


    @Override
    public void viewQuzzes() {

    }

    @Override
    public void getFinalScore() {

    }
}
