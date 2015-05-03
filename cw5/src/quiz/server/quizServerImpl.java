package quiz.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by jimjohn_thornton on 19/04/15.
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
    public void addQuiz() {

    }

    @Override
    public quizImpl getQuiz(int ID) {
        return quizList.get(ID-1);
    }

    @Override
    public void addQuestion(int ID) {

    }

    @Override
    public void deleteQuestion(int ID) {

    }

    @Override
    public int getHighScore(int ID) {
        return quizList.get(ID-1).getHighScore();
    }

    @Override
    public void setHighScore(ArrayList<quizImpl> quizList) throws RemoteException {
        this.quizList = quizList;
    }

    @Override
    public void deleteQuiz() throws RemoteException {

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
