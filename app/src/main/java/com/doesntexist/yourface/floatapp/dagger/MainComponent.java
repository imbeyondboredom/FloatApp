package com.doesntexist.yourface.floatapp.dagger;

import com.doesntexist.yourface.floatapp.activity.OverviewActivity;
import com.doesntexist.yourface.floatapp.adapter.TaskAdapter;
import com.doesntexist.yourface.floatapp.fragment.ScheduleFragment;
import com.doesntexist.yourface.floatapp.loader.FloatTaskLoader;
import com.doesntexist.yourface.floatapp.view.TimelineRowView;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(OverviewActivity activity);
    void inject(ScheduleFragment fragment);
    void inject(FloatTaskLoader loader);
    void inject(TimelineRowView timelineRowView);
    void inject(TaskAdapter taskAdapter);
}
