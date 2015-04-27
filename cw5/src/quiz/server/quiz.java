package quiz.server;

import java.util.List;

/**
 * Created by jimjohn_thornton on 20/04/15.
 */
public interface quiz {

    String getQuizName();

    List<QuestionAndAnswer> getQuestions();

    void addQuestion(String question, String a1, String a2, String a3, String a4, int x);

    int getHighScore();

    String playerWithHighScore();

    void newHighScore(String name, int score);

}
