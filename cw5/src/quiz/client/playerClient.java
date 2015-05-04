package quiz.client;

import java.rmi.Remote;

/**
 * This class is used to play quizzes stored on the server
 * @author Created by James Thornton on 19/04/15.
 */
public interface playerClient extends Remote {

    /**
     *  starts game
     *
     */
    void startGame();

    /**
     *
     * @param ID the quiz number to be played
     * @return selects quiz to be played
     */
    int playQuiz(int ID);

    /**
     *  displays a list of available quizzes
     */
    void viewQuzzes();

    /**
     *  gets score
     */
    void getFinalScore();

}
