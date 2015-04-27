package quiz;

import quiz.server.Answer;
import quiz.server.QuestionAndAnswer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public class setUpClientImpl implements setUpClient, Serializable {

    private static final long serialVersionUID = 3137L;

    @Override
    public int createQuiz(String quizName, List<QuestionAndAnswer> questionAndAnswers, List<Answer> answers) {
        return 0;
    }

    @Override
    public void closeQuiz(int ID) {

    }
}
