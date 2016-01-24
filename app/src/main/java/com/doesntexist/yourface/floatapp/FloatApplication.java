package com.doesntexist.yourface.floatapp;

import android.app.Application;

import com.doesntexist.yourface.floatapp.dagger.DaggerMainComponent;
import com.doesntexist.yourface.floatapp.dagger.DaggerProvider;
import com.doesntexist.yourface.floatapp.dagger.MainComponent;
import com.doesntexist.yourface.floatapp.dagger.MainModule;

/**
 * Created by charlie on 1/19/16.
 */
public class FloatApplication extends Application implements DaggerProvider {

    private MainComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();
    }

    @Override
    public synchronized MainComponent getMainComponent() {
        return mComponent;
    }
}
