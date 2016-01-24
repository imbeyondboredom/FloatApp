package com.doesntexist.yourface.floatapi.models;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by charlie on 1/23/16.
 */
public class FloatProjectTest {

    public Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
    }

    @Test
    public void testGson() throws Exception {
        FloatProject project = gson.fromJson(PROJECT_JSON, FloatProject.class);
        assertThat(project.id).isEqualTo(223);
        assertThat(project.color).isEqualTo("9e7fba");
    }

    private static final String PROJECT_JSON = "{\n" +
            "            \"project_id\": \"223\",\n" +
            "            \"project_name\": \"iPhone App\",\n" +
            "            \"description\": \"Marquee project for us. Need to consider a contractor with app dev skills.\",\n" +
            "            \"color\": \"9e7fba\",\n" +
            "            \"client_id\": \"212\",\n" +
            "            \"client_name\": \"Violet City\",\n" +
            "            \"common\": \"0\",\n" +
            "            \"creator_id\": \"18262\",\n" +
            "            \"created\": \"2014-11-19\",\n" +
            "            \"tags\": [\n" +
            "                        \"IPHONE APP\",\n" +
            "                        \"MEDIUM\"\n" +
            "               ],\n" +
            "            \"non_billable\": \"0\",\n" +
            "            \"active\": \"1\",\n" +
            "            \"project_managers\": [\n" +
            "                    {\n" +
            "                        \"account_id\": \"135\",\n" +
            "                        \"name\": \"Glenn Baron\",\n" +
            "                        \"email\": \"float@pixelpaddock.com\"\n" +
            "                    }\n" +
            "               ]\n" +
            "    }";
}