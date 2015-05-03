package quiz.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public interface quizServer extends Remote {

    void addQuiz() throws RemoteException;

    quizImpl getQuiz(int ID) throws RemoteException;

    ArrayList<quizImpl> getQuizList() throws RemoteException;

    void addQuestion(int ID) throws RemoteException;

    void deleteQuestion(int ID) throws RemoteException;

    int getHighScore(int ID) throws RemoteException;

    void setHighScore(ArrayList<quizImpl> quizList) throws RemoteException;

    void exit() throws RemoteException;

    void deleteQuiz() throws RemoteException;
}
