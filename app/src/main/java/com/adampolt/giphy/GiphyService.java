package com.adampolt.giphy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyService {
    @GET("search")
    Call<GiphyResponse> search(@Query("api_key") String apiKey,
                               @Query("q") String query,
                               @Query("limit") int limit);
}









