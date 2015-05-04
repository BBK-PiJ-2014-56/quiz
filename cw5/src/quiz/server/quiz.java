package quiz.server;

import java.util.List;

/**
 * @author Created by James Thornton on 20/04/15.
 */
public interface quiz {
    /**
     * gets the quiz name
     * @return returns the quiz name
     */
    String getQuizName();

    /**
     * Gets a list of questions
     * @return returns a list of questions and the correct answer
     */
    List<QuestionAndAnswer> getQuestions();

    /**
     * adds a question to the quiz
     * @param question the question being asked
     * @param a1 the first possible answer
     * @param a2 the second possible answer
     * @param a3 the third possible answer
     * @param a4 the fourth possible answer
     * @param x the correct answer
     */
    void addQuestion(String question, String a1, String a2, String a3, String a4, int x);

    /**
     * gets the high score
     * @return an int with the current high score for this quiz
     */
    int getHighScore();

    /**
     * gets the name of the player with the current high score
     * @return a string with the players name with the current high score
     */
    String playerWithHighScore();

    /**
     * sets a new high score
     * @param name the players name with the new high score
     * @param score the new high score
     */
    void newHighScore(String name, int score);

}
