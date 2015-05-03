package quiz.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public interface setUpClient {
    void createQuiz(String quizName);//, List<QuestionAndAnswer> questionAndAnswers, List<Answer> answers);
    void closeQuiz(int ID);

    void startEditor() throws RemoteException, NotBoundException;

    void editQuiz();

    void deleteQuiz(int ID);
}
