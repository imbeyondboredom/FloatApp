package com.doesntexist.yourface.floatapi;

import com.doesntexist.yourface.floatapi.models.FloatTaskResponse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by charlie on 1/9/16.
 */
public class FloatApiTest {

    FloatApi api;

    @Before
    public void setUp() throws Exception {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.floatschedule.com/api/v1/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(FloatApi.class);

    }

    @Test
    @Ignore
    public void testGetTasks() throws Exception {
        Call<FloatTaskResponse> responseCall = api.getTasks();
        retrofit2.Response<FloatTaskResponse> response = responseCall.execute();
        assertThat(response.isSuccess()).isTrue();
    }


    public static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request newRequest;

            newRequest = request.newBuilder()
                    .addHeader("Authorization", "") //Add your Authorization
                    .addHeader("User-Agent", "") // Add your user agent
                    .addHeader("Accept", "application/json")
                    .build();
            return chain.proceed(newRequest);
        }
    }

}