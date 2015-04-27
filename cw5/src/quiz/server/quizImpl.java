package quiz.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimjohn_thornton on 20/04/15.
 */
public class quizImpl implements quiz, Serializable {

    private static final long serialVersionUID = 313L;

    private String quizName;
    private List<QuestionAndAnswer> questions;
    private String playerWithTheHighestScore;
    private int highScore = -1;

    public quizImpl (String quizName) {
        this.quizName = quizName;
        this.questions = new ArrayList<QuestionAndAnswer>();
    }

    public quizImpl (String quizName, String name, int highScore) {
        this.quizName = quizName;
        this.questions = new ArrayList<QuestionAndAnswer>();
        playerWithTheHighestScore = name;
        this.highScore = highScore;
    }

    @Override
    public String getQuizName() {
        return this.quizName;
    }

    @Override
    public List<QuestionAndAnswer> getQuestions() {
        return this.questions;
    }

    @Override
    public void addQuestion(String question, String a1, String a2, String a3, String a4, int x) {
        questions.add(new QuestionAndAnswer(question, new answerImpl(a1, a2, a3, a4, x)));
    }
    @Override
    public int getHighScore() {
        return highScore;
    }

    @Override
    public String playerWithHighScore() {
        return playerWithTheHighestScore;
    }

    @Override
    public void newHighScore(String name, int score) {
        playerWithTheHighestScore = name;
        highScore = score;
    }
}
