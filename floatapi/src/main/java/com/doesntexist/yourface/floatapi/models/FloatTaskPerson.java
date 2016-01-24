package com.doesntexist.yourface.floatapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by charlie on 1/10/16.
 */
public class FloatTaskPerson {
    /*
            "people_id" : "74601",
            "tasks" :
               [
                  {
                     "task_id" : "3454197",
     */

    @SerializedName("people_id")
    public double personId;
    @SerializedName("tasks")
    public ArrayList<FloatTask> tasks;
}
