package com.doesntexist.yourface.floatapi.models;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by charlie on 1/9/16.
 */
public class FloatTaskTest {

    Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
    }

    @Test
    public void testSampleFromJson() throws Exception {
        FloatTask task = gson.fromJson(TASK_JSON, FloatTask.class);
        assertThat(task.id).isEqualTo("2148095612");
        assertThat(task.name).isEqualTo("Design");
        assertThat(task.notes).isEqualTo("See related ticket.");
        assertThat(task.personId).isEqualTo("23654");
        assertThat(task.person_name).isEqualTo("Paul Artisen");
    }

    public final static String TASK_JSON = "{\n" +
            "            \"task_id\": \"2148095612\",\n" +
            "            \"task_name\": \"Design\",\n" +
            "            \"task_notes\": \"See related ticket.\",\n" +
            "            \"people_id\": \"23654\",\n" +
            "            \"person_name:\": \"Paul Artisen\",\n" +
            "            \"project_id\": \"364221\",\n" +
            "            \"project_name\": \"Microsite\",\n" +
            "            \"client_name\": \"Violet City\",\n" +
            "            \"start_date\": \"2014-03-17\",\n" +
            "            \"end_date\": \"2014-03-21\",\n" +
            "            \"hours_pd\": \"8.0\",\n" +
            "            \"task_cal_days\": \"5\",\n" +
            "            \"created_by\": \"Glenn Baron\",\n" +
            "            \"creator_id\": \"135\",\n" +
            "            \"modified_by\": \"Glenn Baron\",\n" +
            "            \"priority\": 0\n" +
            "        }";
}