package com.doesntexist.yourface.floatapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.doesntexist.yourface.floatapp.R;
import com.doesntexist.yourface.floatapp.view.TimelineRowView;

/**
 * Created by charlie on 1/16/16.
 */
public class TaskViewHolder extends RecyclerView.ViewHolder {
    public static final int LAYOUT_RESOURCE = R.layout.float_row;
    public TimelineRowView mTimelineRowView;

    public TaskViewHolder(View itemView) {
        super(itemView);
        mTimelineRowView = (TimelineRowView) itemView;
    }
}
