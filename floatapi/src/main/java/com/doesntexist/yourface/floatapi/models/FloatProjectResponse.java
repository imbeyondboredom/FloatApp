package com.doesntexist.yourface.floatapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by charlie on 1/23/16.
 */
public class FloatProjectResponse {
    @SerializedName("projects")
    public List<FloatProject> projects;
}
