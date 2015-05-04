package quiz.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * @author James Thornton on 19/04/15.
 */
public class quizServerImpl extends UnicastRemoteObject implements quizServer {

    private ArrayList<quizImpl> quizList = new ArrayList<quizImpl>();

    protected quizServerImpl() throws IOException {
        DataIO io = new DataIO();
        quizList = io.readFile();
    }

    @Override
    public ArrayList<quizImpl> getQuizList() throws RemoteException {
        return quizList;
    }

    @Override
    public void addQuiz(String quizName) {
        quizList.add(new quizImpl(quizName));
    }

    @Override
    public quizImpl getQuiz(String quizName) throws RemoteException {
        for (quizImpl q : quizList)
            if (q.getQuizName().equals(quizName))
                return q;
        System.out.println("quiz not found");
        return null;
    }

    @Override
    public void addQuestion(String quizName, String question, String a1, String a2, String a3, String a4, int correctAnswer) throws RemoteException {
        getQuiz(quizName).addQuestion(question, a1, a2, a3, a4, correctAnswer);
    }

    @Override
    public void deleteQuestion(String quizName) {

    }

    @Override
    public int getHighScore(String quizName) throws RemoteException {
        return getQuiz(quizName).getHighScore();
    }

    @Override
    public void setHighScore(ArrayList<quizImpl> quizList) throws RemoteException {
        this.quizList = quizList;
    }

    @Override
    public void deleteQuiz(String quizName) throws RemoteException {

    }

    @Override
    public void exit() throws RemoteException {
        DataIO ioWrite = new DataIO(quizList);
        try{
            Naming.unbind("myQuiz");
            UnicastRemoteObject.unexportObject(this, true);
            System.out.println("Quiz server exiting.");
        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
