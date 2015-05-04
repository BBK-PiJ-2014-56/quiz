package quiz.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author James Thornton on 19/04/15.
 */
public interface quizServer extends Remote {
    /**
     * Adds a new quiz with a given name
     * @param quizName the new quizzes name
     * @throws RemoteException
     */
    void addQuiz(String quizName) throws RemoteException;

    //quizImpl getQuiz(int ID) throws RemoteException;

    /**
     * gets the specified quiz
     * @param quizName the new quizzes name
     * @return the quiz with the correct name
     * @throws RemoteException
     */
    quizImpl getQuiz(String quizName) throws RemoteException;

    /**
     * Gets a list of all quizzes
     * @return an array of quizzes
     * @throws RemoteException
     */
    ArrayList<quizImpl> getQuizList() throws RemoteException;

    /**
     * adds a question to a specified quiz
     * @param quizName the new quizzes name
     * @param question the question being added
     * @param a1 answer option 1
     * @param a2 answer option 2
     * @param a3 answer option 3
     * @param a4 answer option 4
     * @param correctAnswer the correct answer
     * @throws RemoteException
     */
    void addQuestion(String quizName, String question, String a1, String a2, String a3, String a4, int correctAnswer) throws RemoteException;

    /**
     * deletes the most recently added question
     * @param quizName the new quizzes name
     * @throws RemoteException
     */
    void deleteQuestion(String quizName) throws RemoteException;

    /**
     * gets the current high score
     * @param quizName the new quizzes name
     * @return returns an int with the current high score for that quiz
     * @throws RemoteException
     */
    int getHighScore(String quizName)throws RemoteException;

    /**
     * Updates the quizList with a quizlist containing the new high score
     * @param quizList a list of all quizzes
     * @throws RemoteException
     */
    void setHighScore(ArrayList<quizImpl> quizList) throws RemoteException;

    /**
     * Shuts down quiz server
     * @throws RemoteException
     */
    void exit() throws RemoteException;

    /**
     * deletes an entire quiz
     * @param quizName the new quizzes name
     * @throws RemoteException
     */
    void deleteQuiz(String quizName) throws RemoteException;
}
