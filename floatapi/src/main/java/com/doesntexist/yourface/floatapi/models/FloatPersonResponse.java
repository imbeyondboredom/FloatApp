package com.doesntexist.yourface.floatapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by charlie on 1/24/16.
 */
public class FloatPersonResponse {
    @SerializedName("people")
    public List<FloatPerson> people;
}
