package com.doesntexist.yourface.floatapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by charlie on 1/9/16.
 */
public class FloatTaskResponse {

   @SerializedName("start_doy")
   public int startDayOfYear;
   @SerializedName("start_yr")
   public int startYear;
   @SerializedName("people")
   ArrayList<FloatTaskPerson> people;

}
