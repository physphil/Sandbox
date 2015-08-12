package com.physphil.android.sandbox;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.physphil.android.sandbox.api.ApiClient;
import com.physphil.android.sandbox.api.SportsApiClient;
import com.physphil.android.sandbox.models.Player;
import com.physphil.android.sandbox.models.PlayerListEvent;
import com.physphil.android.sandbox.models.PlayerListService;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by pshadlyn on 8/5/2015.
 */
public class Sandbox extends Activity {

    private Handler mHandler = new Handler();
    private List<Player> mPlayers;

    private void test(){

        final int teamId = 21;
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Player> players = ApiClient.getInstance().getPlayerList(teamId);

                // send data to UI thread to update
                Message msg = new Message();
                Bundle data = new Bundle();
                data.putParcelableArrayList("player_list", players);
                msg.setData(data);
                mHandler.sendMessage(msg);
            }
        }).run();


        new AsyncTask<Integer, Void, List<Player>>(){

            @Override
            protected List<Player> doInBackground(Integer... params) {
                int teamId = params[0];
                return ApiClient.getInstance().getPlayerList(teamId);
            }

            @Override
            protected void onPostExecute(List<Player> players) {

                // runs on UI thread, update list of players
            }
        }.execute(teamId);


        // Start with intent
        Intent i = new Intent(this, PlayerListService.class);
        startService(i);

        // Register in onCreate, onResume, onAttach, etc
        EventBus.getDefault().register(this);

        SportsApiClient.getInstance().getPlayerList(teamId, new Callback<List<Player>>() {
            @Override
            public void success(List<Player> players, Response response) {
                // called on main thread, update UI
            }

            @Override
            public void failure(RetrofitError error) {
                // uh oh, there was a problem.
            }
        });

    }

    // Public method to which EventBus delivers event
    public void onEventMainThread(PlayerListEvent event){
        mPlayers = event.getPlayers();
        // update UI...
    }

}
