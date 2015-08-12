package com.physphil.android.sandbox.api;

import com.physphil.android.sandbox.models.Player;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 *
 */

public interface SportsApi {
    @GET("/teams/{id}/players")
    void getPlayerList(@Path("id") int teamId, Callback<List<Player>> callback);
}
