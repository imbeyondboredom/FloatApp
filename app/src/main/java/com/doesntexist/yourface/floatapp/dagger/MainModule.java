package com.doesntexist.yourface.floatapp.dagger;

import android.content.Context;
import android.os.Build;

import com.doesntexist.yourface.floatapi.FloatApi;
import com.doesntexist.yourface.floatapp.BuildConfig;
import com.doesntexist.yourface.floatapp.configurable.FloatDimensions;
import com.doesntexist.yourface.floatapp.floatcustom.FloatProjectManager;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public FloatDimensions providesFloatDimensions() {
        return new FloatDimensions();
    }

    @Provides
    @Singleton
    public FloatProjectManager providesFloatProjectManager() {
        return new FloatProjectManager();
    }

    @Provides
    @Singleton
    public FloatApi providesApi() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
//                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.floatschedule.com/api/v1/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(FloatApi.class);
    }

    public static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request newRequest;

            newRequest = request.newBuilder()
                    .addHeader("Authorization", BuildConfig.AUTHORIZATION)
                    .addHeader("User-Agent", BuildConfig.USER_AGENT)
                    .addHeader("Accept", "application/json")
                    .build();
            return chain.proceed(newRequest);
        }
    }
}
