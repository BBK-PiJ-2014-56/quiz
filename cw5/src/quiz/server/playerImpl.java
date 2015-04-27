package quiz.server;

import java.io.Serializable;

/**
 * Created by jimjohn_thornton on 19/04/15.
 */
public class playerImpl implements player, Serializable {

    private static final long serialVersionUID = 3134L;

    private String playerName;

    public playerImpl(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }
}
