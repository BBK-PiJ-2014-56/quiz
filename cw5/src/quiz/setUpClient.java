package quiz;

import quiz.server.Answer;
import quiz.server.QuestionAndAnswer;

import java.util.List;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public interface setUpClient {
    int createQuiz(String quizName, List<QuestionAndAnswer> questionAndAnswers, List<Answer> answers);
    void closeQuiz(int ID);

}
