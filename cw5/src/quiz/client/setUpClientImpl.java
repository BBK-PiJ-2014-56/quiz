package quiz.client;

import quiz.server.*;


import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public class setUpClientImpl implements setUpClient, Serializable {

    private static final long serialVersionUID = 3137L;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        setUpClientImpl game = new setUpClientImpl();
        game.startEditor();
    }

    @Override
    public void startEditor() throws RemoteException, NotBoundException {
        System.out.println("would you like to ");
        System.out.println("1) Create a new quiz");
        System.out.println("2) Add to an existing quiz");
        System.out.println("3) Delete a question from a quiz");
        System.out.println("4) Delete a quiz");
        System.out.println("5) Shutdown server");
        Scanner sc = new Scanner(System.in);

        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        quizServer impl = (quizServer) myRegistry.lookup("myQuiz");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("enter quiz name");
            String quizName = sc.next();
            impl.addQuiz();
        } else if (choice == 2) {
            System.out.println("enter quiz ID to add question to");
            int ID = sc.nextInt();
            impl.addQuestion(ID);
        } else if (choice == 3) {
            System.out.println("enter quiz ID to be deleted");
            int ID = sc.nextInt();
            impl.deleteQuestion(ID);
            deleteQuiz(ID);
        } else if (choice == 4) {
            impl.deleteQuiz();
        } else if (choice == 5) {
            impl.exit();
        } else {
            System.out.println("Make another choice");
            startEditor();
        }
    }

    @Override
    public void editQuiz() {

    }

    @Override
    public void deleteQuiz(int ID) {

    }

    @Override
    public void createQuiz(String quizName) {//, List<QuestionAndAnswer> questionAndAnswers, List<Answer> answers) {

    }

    @Override
    public void closeQuiz(int ID) {

    }
}
