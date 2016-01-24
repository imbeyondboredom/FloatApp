package com.doesntexist.yourface.floatapp.loader;

import android.content.Context;

import com.doesntexist.yourface.floatapi.FloatApi;
import com.doesntexist.yourface.floatapi.models.FloatTaskResponse;
import com.doesntexist.yourface.floatapp.dagger.DaggerProvider;
import com.doesntexist.yourface.floatapp.floatcustom.FloatProjectManager;

import javax.inject.Inject;

/**
 * Created by charlie on 1/17/16.
 */
public class FloatTaskLoader extends ExecutorServiceLoader<FloatTaskResponse> {

    @Inject
    FloatApi mApi;

    @Inject
    FloatProjectManager projectManager;

    public FloatTaskLoader(Context context) {
        super(context);
        ((DaggerProvider) (context.getApplicationContext())).getMainComponent().inject(this);
    }

    @Override
    protected ResultOrException<FloatTaskResponse, Exception> loadInBackground() {
        try {
            if(!projectManager.hasProjects()) {
                projectManager.setProjects(mApi.getProjects().execute().body().projects);
            }
            return new ResultOrException<>(mApi.getTasks().execute().body());
        } catch (Exception e) {
            return new ResultOrException<>(e);
        }
    }
}
