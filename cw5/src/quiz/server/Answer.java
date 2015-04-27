package quiz.server;

import java.util.List;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public interface Answer {

    //might need a questionID here
    boolean checkAnswer(int x);
    List<String> getAllAnswers();
    int getCorrectAnswer();
}
