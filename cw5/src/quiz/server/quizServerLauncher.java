package quiz.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by jimjohn_thornton on 23/04/15.
 */
public class quizServerLauncher {
    private void startServer(){
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("myquiz", new quizServerImpl());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("system is ready");

    }

    public static void main(String[] args) {
        quizServerLauncher quizserv = new quizServerLauncher();
        quizserv.startServer();
    }
}
