package com.doesntexist.yourface.floatapi.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by charlie on 1/9/16.
 */
public class FloatTask {

    /* Here is a sample JSON for a task
    {
    "task_id": "123434",
    "task_name": "User Experience",
    "task_notes": "Reference wireframes doc.",
    "people_id": "236",
    "person_name:": "Paul Artisen",
    "project_id": "364",
    "project_name": "Microsite",
    "client_name": "Violet City",
    "start_date": "2014-03-17",
    "end_date": "2014-03-21",
    "hours_pd": "8.0",
    "task_cal_days": "5",
    "created_by": "Glenn Baron",
    "creator_id": "135",
    "modified_by": "Glenn Baron",
    "priority": 0,

    }
     */
    @SerializedName("task_id")
    public String id;
    @SerializedName("task_name")
    public String name;
    @SerializedName("task_notes")
    public String notes;
    @SerializedName("people_id")
    public String personId;
    @SerializedName("person_name")
    public String person_name;
    @SerializedName("project_id")
    public String projectId;
    @SerializedName("project_name")
    public String projectName;
    @SerializedName("client_name")
    public String clientName;
    @SerializedName("start_date")
    public String startDate;
    @SerializedName("end_date")
    public String endDate;
    @SerializedName("hours_pd")
    public double hoursPerDay;
    @SerializedName("task_cal_days")
    public double calendarDays;
    @SerializedName("created_by")
    public String createdBy;
    @SerializedName("creator_id")
    public String creatorId;
    @SerializedName("modified_by")
    public String modifiedBy;
    @SerializedName("priority")
    public String priority;
}
