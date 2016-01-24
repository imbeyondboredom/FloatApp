package com.doesntexist.yourface.floatapi;

import com.doesntexist.yourface.floatapi.models.FloatPersonResponse;
import com.doesntexist.yourface.floatapi.models.FloatProjectResponse;
import com.doesntexist.yourface.floatapi.models.FloatTaskResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FloatApi {
    @GET("tasks")
    Call<FloatTaskResponse> getTasks();

    @GET("projects")
    Call<FloatProjectResponse> getProjects();

    @GET("people")
    Call<FloatPersonResponse> getPeople();
}
