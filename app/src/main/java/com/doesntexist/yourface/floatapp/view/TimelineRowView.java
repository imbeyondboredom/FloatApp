package com.doesntexist.yourface.floatapp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.doesntexist.yourface.floatapp.configurable.FloatDimensions;
import com.doesntexist.yourface.floatapp.dagger.DaggerProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import static com.doesntexist.yourface.floatapp.utils.DrawingUtils.dpToPx;

/**
 * Created by charlie on 1/19/16.
 */
public class TimelineRowView extends View {
    private List<TimeBlock> mBlocks = Collections.emptyList();

    @Inject
    FloatDimensions mDimensions;
    private Paint mBorderPaint;
    private Paint mWeekPaint;
    private Paint mDayPaint;
    private Paint subTitlePaint;
    private Paint titlePaint;
    private TextPaint titleTextPaint;
    private TextPaint subTitleTextPaint;

    public TimelineRowView(Context context) {
        super(context);
        init(context);
    }

    public TimelineRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TimelineRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TimelineRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        if (isInEditMode()) {
            mDimensions = new FloatDimensions();
            mBlocks = new ArrayList<>();
            TimelineRowView.TimeBlock block = new TimelineRowView.TimeBlock();
            block.startDay = 0; //TODO figure out how to get this..
            block.duration = 5;
            block.title = "Sample Title";
            block.subTitle = "Sample Client";
            block.paint = new Paint();
            block.paint.setColor(Color.BLUE);
            block.paint.setAlpha(255 / 5); //20% alpha
            mBlocks.add(block);
            block = new TimelineRowView.TimeBlock();
            block.startDay = 6; //TODO figure out how to get this..
            block.duration = 5;
            block.title = "Sample Title";
            block.subTitle = "Sample Client";
            block.paint = new Paint();
            block.paint.setColor(Color.BLUE);
            block.paint.setAlpha(255 / 5); //20% alpha
            mBlocks.add(block);
        } else {
            ((DaggerProvider) (context.getApplicationContext())).getMainComponent().inject(this);
        }

        mBorderPaint = new Paint();
        mBorderPaint.setColor(Color.BLACK);
        mBorderPaint.setStyle(Paint.Style.STROKE);

        titlePaint = new Paint();
        titlePaint.setColor(Color.BLACK);
        titlePaint.setStyle(Paint.Style.STROKE);
        titlePaint.setTextSize(dpToPx(context, mDimensions.titleTextSize));
        titleTextPaint = new TextPaint(titlePaint);

        subTitlePaint = new Paint();
        subTitlePaint.setColor(Color.BLACK);
        subTitlePaint.setStyle(Paint.Style.STROKE);
        subTitlePaint.setTextSize(dpToPx(context, mDimensions.subtitleTextSize));
        subTitleTextPaint = new TextPaint(subTitlePaint);

        mDayPaint = new Paint();
        mDayPaint.setColor(Color.BLACK);
        mDayPaint.setStyle(Paint.Style.STROKE);
        mDayPaint.setAlpha(255 / 6);

        mWeekPaint = new Paint();
        mWeekPaint.setColor(Color.BLACK);
        mWeekPaint.setStyle(Paint.Style.STROKE);
//        mWeekPaint.setAlpha(255 / 6);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int minw = getPaddingLeft() + getPaddingRight() + (int) (dpToPx(getContext(), mDimensions.numberOfDaysToShow * mDimensions.dayWidth));
        int w = resolveSizeAndState(minw, widthMeasureSpec, 0);
//        int w = MeasureSpec.getSize(minw);

        int minh = MeasureSpec.getSize((int) dpToPx(getContext(), mDimensions.rowHeight)) + getPaddingBottom() + getPaddingTop();
//        int h = resolveSizeAndState(MeasureSpec.getSize(w) - (int)mTextWidth, heightMeasureSpec, 0);
//        int h =MeasureSpec.getSize(minh);
        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);

        for(int a = 0; a<mBlocks.size(); a++) {
            TimeBlock block = mBlocks.get(a);
            block.title = TextUtils.ellipsize(block.title, titleTextPaint, dpToPx(getContext(), (float)(mBlocks.get(a).duration * mDimensions.dayWidth)), TextUtils.TruncateAt.END);
            block.subTitle = TextUtils.ellipsize(block.subTitle, subTitleTextPaint, dpToPx(getContext(), (float)(mBlocks.get(a).duration * mDimensions.dayWidth)), TextUtils.TruncateAt.END);
        }

        setMeasuredDimension(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Draw the blocks
        int size = mBlocks.size();
        TimeBlock block;
        for (int i = 0; i < size; i++) {
            block = mBlocks.get(i);
            float duration = (float) (block.startDay + block.duration);
            if (duration > mDimensions.numberOfDaysToShow) {
                duration = mDimensions.numberOfDaysToShow - block.startDay;
            }
            canvas.drawRect(dpToPx(getContext(), block.startDay * mDimensions.dayWidth), 0, dpToPx(getContext(), duration * mDimensions.dayWidth), dpToPx(getContext(), mDimensions.rowHeight), block.paint);

            //Only draw text if it will fit in the box
            if (mDimensions.rowHeight > mDimensions.titleTextSize + mDimensions.subtitleTextSize) {
                int textY = (int) (mDimensions.rowHeight - (mDimensions.titleTextSize) - mDimensions.subtitleTextSize);
                canvas.drawText(block.title, 0, block.title.length(), dpToPx(getContext(), block.startDay * mDimensions.dayWidth), dpToPx(getContext(), textY), titleTextPaint);
                canvas.drawText(block.subTitle, 0, block.subTitle.length(), dpToPx(getContext(), block.startDay * mDimensions.dayWidth), dpToPx(getContext(), textY + mDimensions.titleTextSize), subTitlePaint);
            } else if (mDimensions.rowHeight > mDimensions.titleTextSize) {
                canvas.drawText(block.title, 0, block.title.length(), dpToPx(getContext(), block.startDay * mDimensions.dayWidth), dpToPx(getContext(), mDimensions.rowHeight), titleTextPaint);
            } // If we can't draw text then don't

        }

        //Draw the border
        canvas.drawRect(0, 0, dpToPx(getContext(), mDimensions.numberOfDaysToShow * mDimensions.dayWidth), dpToPx(getContext(), mDimensions.rowHeight), mBorderPaint);

        //Draw the day borders
        int weeks = mDimensions.numberOfDaysToShow / 7;
        float rowHeight = dpToPx(getContext(), mDimensions.rowHeight);
        for (int a = 0; a < mDimensions.numberOfDaysToShow; a++) {
            float x = dpToPx(getContext(), a * mDimensions.dayWidth);
            canvas.drawLine(x, 0, x, rowHeight, mDayPaint);
        }

        //Draw the week borders
        for (int a = 0; a < weeks; a++) {
            float x = dpToPx(getContext(), a * 7 * mDimensions.dayWidth);
            canvas.drawLine(x, 0, x, rowHeight, mWeekPaint);
        }
    }

    public void setBlocks(List<TimeBlock> blocks) {
        mBlocks = blocks;
        invalidate();
    }

    public static class TimeBlock {
        public int startDay = 0;
        public double duration = 0;
        public CharSequence title = "";
        public CharSequence subTitle = "";
        public Paint paint;
    }
}
