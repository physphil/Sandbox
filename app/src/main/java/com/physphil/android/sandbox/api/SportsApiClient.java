package com.physphil.android.sandbox.api;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Retrofit Client
 */
public class SportsApiClient {
    private static SportsApi mApiService;

    public static SportsApi getInstance() {

        if (mApiService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://www.baseball.com/API/")
                    .setClient(new OkClient(new OkHttpClient()))
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            mApiService = restAdapter.create(SportsApi.class);
        }

        return mApiService;
    }
}
