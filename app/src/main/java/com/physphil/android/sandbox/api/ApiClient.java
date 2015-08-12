package com.physphil.android.sandbox.api;

import com.physphil.android.sandbox.models.Player;

import java.util.ArrayList;

/**
 * Created by pshadlyn on 8/5/2015.
 */
public class ApiClient {

    public static ApiClient getInstance(){
        return new ApiClient();
    }

    public ArrayList<Player> getPlayerList(int teamId){
        return null;
    }
}
