package quiz.server;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public class QuestionAndAnswer implements Serializable {

    private static final long serialVersionUID = 3135L;

    private List<String> questions;
    private List<String> allAnswers;
    private answerImpl answers;
    private int questionNumber = 0;
    private String question;
    private int answer;
    public QuestionAndAnswer (String question, answerImpl answers) {
        this.question = question;
        this.answers = answers;
        this.questionNumber = questionNumber++;
        //maybe change this to an answer object...?
        //this.answer = answer;


    }
    public boolean getAnswer(int x){
        return answers.checkAnswer(x);
    }
    public String getQuestion(){
        return question;
    }
    public List<String> getAllAnswers() {
        allAnswers = answers.getAllAnswers();
        return allAnswers;
    }
    public int getCorrectAnswer(){
        return answers.getCorrectAnswer();
    }
}
