package com.doesntexist.yourface.floatapi;

import org.junit.Before;
import org.junit.Test;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by charlie on 1/9/16.
 */
public class FloatApiTest {

    FloatApi api;

    @Before
    public void setUp() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(FloatApi.class);
    }

    @Test
    public void testGetTasks() throws Exception {

    }

}