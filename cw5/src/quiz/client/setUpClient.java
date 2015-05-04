package quiz.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * This class is used to edit quizzes stored on the server and shutdown the server
 * @author Created by James Thornton on 19/04/15.
 */
public interface setUpClient {
    /**
     * starts the editor
     * @throws RemoteException
     * @throws NotBoundException
     */
    void startEditor() throws RemoteException, NotBoundException;

}
