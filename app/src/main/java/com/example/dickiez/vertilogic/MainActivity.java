package com.example.dickiez.vertilogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dickiez.vertilogic.Adapter.CustomAdapter;
import com.example.dickiez.vertilogic.Model.User;
import com.example.dickiez.vertilogic.Server.ApiClient;
import com.example.dickiez.vertilogic.Server.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<User> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);

        getUsers();

    }

    private void getUsers() {
        ApiInterface api = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<User>> call = api.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                result = response.body();
                mAdapter = new CustomAdapter(result, MainActivity.this);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
