package quiz.server;

import java.util.List;

/**
 * @author James Thornton on 19/04/15.
 */
public interface Answer {

    /**
     * Checks to see if answer is correct
     * @param x answer to be checked
     * @return true or false depending on whether the player gets the answer correct
     */
    boolean checkAnswer(int x);

    /**
     * Gets available answers
     * @return returns a list of the possible answer choices
     */
    List<String> getAllAnswers();

    /**
     * tells you which answer is the correct one
     * @return returns an int for the correct answer
     */
    int getCorrectAnswer();
}
