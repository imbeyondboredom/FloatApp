package com.doesntexist.yourface.floatapp.floatcustom;

import android.graphics.Color;
import android.util.SparseArray;

import com.doesntexist.yourface.floatapi.models.FloatProject;

import java.util.Collections;
import java.util.List;

/**
 * Created by charlie on 1/23/16.
 */
public class FloatProjectManager {
    private List<FloatProject> projects = Collections.emptyList();
    private SparseArray<Integer> projectsToColors;

    public FloatProjectManager() {
        this.projectsToColors = new SparseArray<>();
    }

    public void setProjects(List<FloatProject> tProjects) {
        projects = tProjects;
        for(FloatProject project : tProjects) {
            projectsToColors.put(project.id, Color.parseColor(project.color.startsWith("#") ? project.color : "#"+project.color));
        }
    }

    public int getColor(int projectId) {
        return projectsToColors.get(projectId);
    }

    public boolean hasProjects() {
        return projectsToColors.size() > 0;
    }
}
