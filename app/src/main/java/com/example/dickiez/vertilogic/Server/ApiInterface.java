package com.example.dickiez.vertilogic.Server;

import com.example.dickiez.vertilogic.Model.Company;
import com.example.dickiez.vertilogic.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dickiez on 4/10/2018.
 */

public interface ApiInterface {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("user{id}")
    Call<User> getUserId();
}
