package quiz.server;

import java.io.Serializable;

/**
 * Created by jimjohn_thornton on 21/04/15.
 */
public class quizLauncher implements Serializable{

    private static final long serialVersionUID = 3136L;

    private static playerImpl James;
    private static quizImpl quiz1;
    private static UI ui;

//    public void setUp() {
//        James = new playerImpl("James");
//        quiz1 = new quizImpl("quiz1");
//        quiz1.addQuestion("what does the cat want?", "food", "petting", "water", "love", 1);
//    }
    public static void main(String[] args) {
        James = new playerImpl("James");
        quiz1 = new quizImpl("quiz1");
        quiz1.addQuestion("what does the cat want?", "food", "petting", "water", "love", 1);
        quiz1.addQuestion("why does the cat eat so much?", "he's starving", "he's a fatty", "he's comfort eating", "he gets a lot of exercise", 2);
        ui = new UI(quiz1);
    }

    //public void GUI() {

    //}
}
