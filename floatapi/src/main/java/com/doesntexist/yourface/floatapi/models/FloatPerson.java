package com.doesntexist.yourface.floatapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by charlie on 1/24/16.
 */
public class FloatPerson {
    @SerializedName("people_id")
    public double id;
    @SerializedName("name")
    public String name;
    @SerializedName("department")
    public FloatDepartment department;
    @SerializedName("skills")
    public List<FloatSkill> tags;
}
