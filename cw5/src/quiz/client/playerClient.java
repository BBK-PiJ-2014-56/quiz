package quiz.client;

import java.rmi.Remote;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public interface playerClient extends Remote {

    //starts game
    void startGame();
    //selects quiz to be played
    int playQuiz(int ID);

    //displays a list of available quizzes
    void viewQuzzes();

    //shows score
    void getFinalScore();

}
