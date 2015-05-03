package quiz.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public interface quizServer extends Remote {

    void addQuiz(String quizName) throws RemoteException;

    //quizImpl getQuiz(int ID) throws RemoteException;

    quizImpl getQuiz(String quizName) throws RemoteException;

    ArrayList<quizImpl> getQuizList() throws RemoteException;

    void addQuestion(String quizName, String question, String a1, String a2, String a3, String a4, int correctAnswer) throws RemoteException;

    void deleteQuestion(String quizName) throws RemoteException;

    int getHighScore(String quizName)throws RemoteException;

    void setHighScore(ArrayList<quizImpl> quizList) throws RemoteException;

    void exit() throws RemoteException;

    void deleteQuiz(String quizName) throws RemoteException;
}
