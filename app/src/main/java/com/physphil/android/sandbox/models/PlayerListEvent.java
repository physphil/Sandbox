package com.physphil.android.sandbox.models;

import java.util.List;

/**
 * Created by pshadlyn on 8/5/2015.
 */

// Event Class
public class PlayerListEvent {
    private List<Player> players;

    public PlayerListEvent(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
