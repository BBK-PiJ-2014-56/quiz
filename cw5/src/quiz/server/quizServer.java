package quiz.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public interface quizServer extends Remote {

    void addQuiz() throws RemoteException;

    void getQuiz() throws RemoteException;

    ArrayList<quizImpl> getQuizList() throws RemoteException;

    void addQuestion() throws RemoteException;

    void deleteQuestion() throws RemoteException;

    void getHighScore() throws RemoteException;

    void setHighScore() throws RemoteException;

    void exit() throws RemoteException;

    void deleteQuiz() throws RemoteException;
}
