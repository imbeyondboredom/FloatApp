package com.doesntexist.yourface.floatapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.doesntexist.yourface.floatapi.models.FloatTaskResponse;
import com.doesntexist.yourface.floatapp.R;
import com.doesntexist.yourface.floatapp.adapter.TaskAdapter;
import com.doesntexist.yourface.floatapp.dagger.DaggerProvider;
import com.doesntexist.yourface.floatapp.layoutmanager.FixedGridLayoutManager;
import com.doesntexist.yourface.floatapp.loader.FloatTaskLoader;
import com.doesntexist.yourface.floatapp.loader.ResultOrException;

import java.util.Calendar;

/**
 * Created by charlie on 1/14/16.
 */
public class ScheduleFragment extends Fragment implements AdapterView.OnItemClickListener, LoaderManager.LoaderCallbacks<ResultOrException<FloatTaskResponse, Exception>> {
    private RecyclerView mList;
    private TaskAdapter mAdapter;
    private FixedGridLayoutManager mLayoutManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((DaggerProvider) (context.getApplicationContext())).getMainComponent().inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.schedule_list, container, false);

        mList = (RecyclerView) rootView.findViewById(R.id.section_list);
        mLayoutManager = new FixedGridLayoutManager();
        mLayoutManager.setTotalColumnCount(1);
        mList.setLayoutManager(mLayoutManager);

        mList.getItemAnimator().setAddDuration(1000);
        mList.getItemAnimator().setChangeDuration(1000);
        mList.getItemAnimator().setMoveDuration(1000);
        mList.getItemAnimator().setRemoveDuration(1000);

        mAdapter = new TaskAdapter(getContext());
        mAdapter.setOnItemClickListener(this);
        mList.setAdapter(mAdapter);

        //Init the loader after we've created the views
        getLoaderManager().initLoader(0, null, this);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_filter_option) {

            return true;
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),
                "Clicked: " + position + ", index " + mList.indexOfChild(view),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<ResultOrException<FloatTaskResponse, Exception>> onCreateLoader(int id, Bundle args) {
        return new FloatTaskLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResultOrException<FloatTaskResponse, Exception>> loader, ResultOrException<FloatTaskResponse, Exception> data) {
        if (data.hasResult()) {
            FloatTaskResponse response = data.getResult();
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_YEAR, response.startDayOfYear);
            cal.set(Calendar.YEAR, response.startYear);
            mAdapter.addAll(cal, response.people);
        } else {
            Toast.makeText(loader.getContext(), "Fetching data did not work", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(Loader<ResultOrException<FloatTaskResponse, Exception>> loader) {

    }
}
