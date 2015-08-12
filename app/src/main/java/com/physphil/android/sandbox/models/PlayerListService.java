package com.physphil.android.sandbox.models;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.physphil.android.sandbox.api.ApiClient;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by pshadlyn on 8/5/2015.
 */
public class PlayerListService extends IntentService {

    public static final String ACTION_PLAYER_LIST_DOWNLOADED = "com.test.network.ACTION_PLAYER_LIST_DOWNLOADED";
    public static final String EXTRA_PLAYER_LIST = "com.test.network.EXTRA_PLAYER_LIST";

    public PlayerListService(){
        super("PlayerListService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int teamId = 21;
        List<Player> players = ApiClient.getInstance().getPlayerList(teamId);

        // Send results back to UI thread
        Intent i = new Intent(ACTION_PLAYER_LIST_DOWNLOADED);
        i.putParcelableArrayListExtra(EXTRA_PLAYER_LIST, players);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);

        // Send Player list from IntentService
        EventBus.getDefault().post(new PlayerListEvent(players));
    }
}
