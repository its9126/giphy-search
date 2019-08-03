package com.adampolt.giphy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adampolt.giphy.recycler.GifAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String apiKey = "4KFohUX9fvHKJBHTVfHOg8iYJmHbMTQi";
    GiphyService service;

    RecyclerView recyclerView;
    GifAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.giphy.com/v1/gifs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GiphyService.class);

        search("default", 25);

        Button searchButton = findViewById(R.id.searchButton);
        recyclerView = findViewById(R.id.recyclerView);

        adapter = new GifAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView searchText = findViewById(R.id.searchText);
                String query = searchText.getText().toString();
                search(query, 25);
            }
        });
    }

    private void search(String query, int count) {
        service.search(apiKey, query, count).enqueue(new Callback<GiphyResponse>() {
            @Override
            public void onResponse(Call<GiphyResponse> call, Response<GiphyResponse> response) {

                GiphyResponse giphyResponse = response.body();

                if(giphyResponse != null && giphyResponse.data != null) {
                    adapter.images = giphyResponse.data;
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<GiphyResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
