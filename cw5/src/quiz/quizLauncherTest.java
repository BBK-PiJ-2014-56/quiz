package quiz;

import org.junit.Before;
import org.junit.Test;
import quiz.server.QuestionAndAnswer;
import quiz.server.playerImpl;
import quiz.server.quizImpl;

import static org.junit.Assert.assertEquals;

/**
 * Created by jimjohn_thornton on 21/04/15.
 */
public class quizLauncherTest {

    private playerImpl James;
    private quizImpl quiz1;
    private QuestionAndAnswer q1;

    @Before
    public void setUp() {
        James = new playerImpl("James");
        quiz1 = new quizImpl("quiz1");
        quiz1.addQuestion("what does the cat want?", "food", "petting", "water", "love", 1);
    }
    //Quiz tests
    @Test
    public void getQuizNameTest() {
        assertEquals("quiz1", quiz1.getQuizName());
    }

    @Test
    public void getQuestionsTest() {
        assertEquals(1, quiz1.getQuestions().size());
    }

    @Test
    public void addQuestionTest() {
        quiz1.addQuestion("why does the cat eat so much?", "he's starving", "he's a fatty", "he's comfort eating", "he gets alot of exercise", 2);
        assertEquals(2, quiz1.getQuestions().size());
    }
    @Test
    public void checkAnswerTest() {
        assertEquals(true, quiz1.getQuestions().get(0).getAnswer(1));
        assertEquals(false, quiz1.getQuestions().get(0).getAnswer(2));
        assertEquals(false, quiz1.getQuestions().get(0).getAnswer(3));
        assertEquals(false, quiz1.getQuestions().get(0).getAnswer(4));
        assertEquals(false, quiz1.getQuestions().get(0).getAnswer(5));

    }
//    @Test
//    public void UITest() {
//        UI ui = new UI(quiz1);
//
//
//    }
}