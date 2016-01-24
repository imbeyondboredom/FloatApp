package com.doesntexist.yourface.floatapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.doesntexist.yourface.floatapi.models.FloatTask;
import com.doesntexist.yourface.floatapi.models.FloatTaskPerson;
import com.doesntexist.yourface.floatapp.dagger.DaggerProvider;
import com.doesntexist.yourface.floatapp.floatcustom.FloatProjectManager;
import com.doesntexist.yourface.floatapp.view.TimelineRowView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by charlie on 1/16/16.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private AdapterView.OnItemClickListener mListener;
    private ArrayList<FloatTaskPerson> mList;
    private Calendar mStartDay;

    @Inject
    public FloatProjectManager floatProjectManager;

    public TaskAdapter(Context context) {
        ((DaggerProvider)context.getApplicationContext()).getMainComponent().inject(this);
        mList = new ArrayList<>();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(TaskViewHolder.LAYOUT_RESOURCE, parent, false);
        TaskViewHolder holder = new TaskViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.mTimelineRowView.setBlocks(tasksToBlocks(mStartDay, mList.get(position), floatProjectManager));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        mListener = listener;
    }

    public void addAll(Calendar startDay, ArrayList<FloatTaskPerson> people) {
        mStartDay = startDay;
        mList.clear();
        mList.addAll(people);
        notifyDataSetChanged();
    }

    private static Calendar mTempCal = Calendar.getInstance();
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    private static List<TimelineRowView.TimeBlock> tasksToBlocks(Calendar startDay, FloatTaskPerson floatTaskPerson, FloatProjectManager floatProjectManager) {
        ArrayList<TimelineRowView.TimeBlock> blocks = new ArrayList<>(floatTaskPerson.tasks.size());
        for (FloatTask task : floatTaskPerson.tasks) {
            TimelineRowView.TimeBlock block = new TimelineRowView.TimeBlock();
            try {
                mTempCal.setTime(dateFormatter.parse(task.startDate));
                block.startDay = mTempCal.get(Calendar.DAY_OF_YEAR) - startDay.get(Calendar.DAY_OF_YEAR);
                if(block.startDay < 0) {
                    block.startDay = 0;
                }
                mTempCal.setTime(dateFormatter.parse(task.endDate));
                block.duration = mTempCal.get(Calendar.DAY_OF_YEAR) - startDay.get(Calendar.DAY_OF_YEAR);
                if(block.duration <= 0) {
                    continue; //Skip tasks that wont be shown.
                }
                block.title = task.projectName;
                block.subTitle = task.clientName;
                block.paint = new Paint();
                block.paint.setColor(floatProjectManager.getColor(task.projectId));
                block.paint.setAlpha(255 / 5); //20% alpha
//            block.paint.setColor(task.); //Grr - set by the project color
                blocks.add(block);
            } catch (ParseException pe) {
                //Just ignore blocks we can't parse
            }
        }
        return blocks;
    }

}
