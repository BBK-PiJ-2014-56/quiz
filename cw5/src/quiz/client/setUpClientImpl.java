package quiz.client;

import quiz.server.*;


import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * @author James Thornton on 19/04/15.
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
        Scanner sc2 = new Scanner(System.in);

        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        quizServer impl = (quizServer) myRegistry.lookup("myQuiz");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("enter quiz name");
            String quizName = sc2.nextLine();
            impl.addQuiz(quizName);
            System.out.println("do you want to add any questions at this point? press Y or N");
            String addq = sc2.nextLine();
            if (addq.equals("Y")) {
                while (addq.equals("Y")) {
                    System.out.println("Type in a question ");
                    String question = sc2.nextLine();
                    System.out.println("type in the first of 4 possible answers");
                    String a1 = sc2.nextLine();
                    System.out.println("type in the second of 4 possible answers");
                    String a2 = sc2.nextLine();
                    System.out.println("type in the third of 4 possible answers");
                    String a3 = sc2.nextLine();
                    System.out.println("type in the final answer");
                    String a4 = sc2.nextLine();
                    System.out.println("which answer is correct? enter a number 1 to 4");
                    int correctAnswer = sc2.nextInt();
                    impl.addQuestion(quizName, question, a1, a2, a3, a4, correctAnswer);
                    System.out.println("do you want to add another question, Press Y or N");
                    addq = sc2.nextLine();
                }
            }
            System.out.println("Quiz added");
        } else if (choice == 2) {
            boolean addq = true;
            System.out.println("enter the quiz name to add a question to");
            //String quizName1 = sc.nextLine();
            String quizName = sc2.nextLine();
            System.out.println(quizName);
            //System.out.println(quizName1);
            quizImpl q = impl.getQuiz(quizName);

            if (q == null) {
                System.out.println("not a quiz name");
                addq = false;
            }
            while (addq) {
                System.out.println("Type in a question ");
                String question = sc2.nextLine();
                System.out.println("type in the first of 4 possible answers");
                String a1 = sc2.nextLine();
                System.out.println("type in the second of 4 possible answers");
                String a2 = sc2.nextLine();
                System.out.println("type in the third of 4 possible answers");
                String a3 = sc2.nextLine();
                System.out.println("type in the final answer");
                String a4 = sc2.nextLine();
                System.out.println("which answer is correct? enter a number 1 to 4");
                int correctAnswer = sc2.nextInt();
                impl.addQuestion(quizName, question, a1, a2, a3, a4, correctAnswer);
                System.out.println("do you want to add another question, Press Y or N");
                String more = sc2.nextLine();
                if (!more.equals("Y"))
                    addq = false;
            }
        } else if (choice == 3) {
            System.out.println("enter quiz name to be delete a question from");
            String quizName = sc.next();
            impl.deleteQuestion(quizName);
        } else if (choice == 4) {
            System.out.println("enter quiz name to be delete");
            String quizName = sc.next();
            impl.deleteQuiz(quizName);
        } else if (choice == 5) {
            impl.exit();
        } else {
            System.out.println("Make another choice");
            startEditor();
        }
    }
}