package quiz.server;

import java.io.Serializable;
import java.util.List;

/**
 * @author James Thornton on 19/04/15.
 */
public class QuestionAndAnswer implements Serializable {

    private static final long serialVersionUID = 3135L;

    private List<String> questions;
    private List<String> allAnswers;
    private answerImpl answers;
    private int questionNumber = 0;
    private String question;
    private int answer;

    /**
     * sets up questions and answers for the quiz
     * @param question the question
     * @param answers the answers
     */
    public QuestionAndAnswer (String question, answerImpl answers) {
        this.question = question;
        this.answers = answers;
        this.questionNumber = questionNumber++;
        //maybe change this to an answer object...?
        //this.answer = answer;


    }

    /**
     * checks if the answer is correct
     * @param x the answer
     * @return true or false fi they got it right
     */
    public boolean getAnswer(int x){
        return answers.checkAnswer(x);
    }

    /**
     * gets the question
     * @return the question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * gets all the answers
     * @return a list of all the possible answers
     */
    public List<String> getAllAnswers() {
        allAnswers = answers.getAllAnswers();
        return allAnswers;
    }

    /**
     * gets the correct answer
     * @return the position of the correct answer
     */
    public int getCorrectAnswer(){
        return answers.getCorrectAnswer();
    }
}
