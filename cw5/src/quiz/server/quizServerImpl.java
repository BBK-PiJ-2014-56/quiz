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
    public void getQuiz() {

    }

    @Override
    public void addQuestion() {

    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public void getHighScore() {

    }

    @Override
    public void setHighScore() throws RemoteException {

    }

    @Override
    public void deleteQuiz() throws RemoteException {

    }

    @Override
    public void exit() throws RemoteException {
        try{
            Naming.unbind("myQuiz");
            UnicastRemoteObject.unexportObject(this, true);
            System.out.println("Quiz server exiting.");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
