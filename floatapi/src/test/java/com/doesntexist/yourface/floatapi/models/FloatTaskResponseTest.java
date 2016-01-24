package com.doesntexist.yourface.floatapi.models;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by charlie on 1/10/16.
 */
public class FloatTaskResponseTest {

    Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
    }

    @Test
    public void testFromJson() throws Exception {
        FloatTaskResponse response = gson.fromJson(EXAMPLE_JSON, FloatTaskResponse.class);
        assertThat(response.startDayOfYear).isEqualTo(10);
        assertThat(response.startYear).isEqualTo(2016);
        assertThat(response.people).isNotNull().isNotEmpty();
        assertThat(response.people.size()).isEqualTo(2);
        assertThat(response.people.get(0).personId).isEqualTo(74601);
        assertThat(response.people.get(0).tasks.size()).isEqualTo(1);
        assertThat(response.people.get(0).tasks.get(0).id).isEqualTo(3454197);

    }

    private static final String EXAMPLE_JSON = "{\n" +
            "   \"start_doy\" : \"10\",\n" +
            "   \"start_yr\" : \"2016\",\n" +
            "   \"people\" :\n" +
            "      [\n" +
            "         {\n" +
            "            \"people_id\" : \"74601\",\n" +
            "            \"tasks\" :\n" +
            "               [\n" +
            "                  {\n" +
            "                     \"task_id\" : \"3454197\",\n" +
            "                     \"task_name\" : \"Some Engineering\",\n" +
            "                     \"task_notes\" : \"Guy requested\",\n" +
            "                     \"people_id\" : \"74601\",\n" +
            "                     \"person_name\" : \"Romeo\",\n" +
            "                     \"project_id\" : \"421697\",\n" +
            "                     \"project_name\" : \"Labs\",\n" +
            "                     \"client_name\" : \"My Labs\",\n" +
            "                     \"start_date\" : \"2016-01-04\",\n" +
            "                     \"start_yr\" : \"2016\",\n" +
            "                     \"end_date\" : \"2016-04-29\",\n" +
            "                     \"hours_pd\" : \"8.0\",\n" +
            "                     \"total_hours\" : \"680.0\",\n" +
            "                     \"task_days\" : \"85\",\n" +
            "                     \"task_cal_days\" : \"117\",\n" +
            "                     \"created_by\" : \"Aircraft Carrier\",\n" +
            "                     \"creator_id\" : \"40732\",\n" +
            "                     \"modified_by\" : \"Admin Pearson\",\n" +
            "                     \"priority\" : 1,\n" +
            "                     \"tentative\" : 0\n" +
            "                  }\n" +
            "               ]\n" +
            "         },\n" +
            "         {\n" +
            "            \"people_id\" : \"74602\",\n" +
            "            \"tasks\" :\n" +
            "               [\n" +
            "                  {\n" +
            "                     \"task_id\" : \"3396730\",\n" +
            "                     \"task_name\" : \"Android Develompent\",\n" +
            "                     \"task_notes\" : null,\n" +
            "                     \"people_id\" : \"74602\",\n" +
            "                     \"person_name\" : \"Texas Ranger\",\n" +
            "                     \"project_id\" : \"414072\",\n" +
            "                     \"project_name\" : \"Super Secret\",\n" +
            "                     \"client_name\" : \"Santa\",\n" +
            "                     \"start_date\" : \"2015-11-16\",\n" +
            "                     \"start_yr\" : \"2016\",\n" +
            "                     \"end_date\" : \"2016-03-04\",\n" +
            "                     \"hours_pd\" : \"8.0\",\n" +
            "                     \"total_hours\" : \"640.0\",\n" +
            "                     \"task_days\" : \"80\",\n" +
            "                     \"task_cal_days\" : \"110\",\n" +
            "                     \"created_by\" : \"Admin Pearson\",\n" +
            "                     \"creator_id\" : \"66112\",\n" +
            "                     \"modified_by\" : null,\n" +
            "                     \"priority\" : 0,\n" +
            "                     \"tentative\" : 0\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"task_id\" : \"3969672\",\n" +
            "                     \"task_name\" : \"Android Development\",\n" +
            "                     \"task_notes\" : null,\n" +
            "                     \"people_id\" : \"74602\",\n" +
            "                     \"person_name\" : \"Texas Ranger\",\n" +
            "                     \"project_id\" : \"486020\",\n" +
            "                     \"project_name\" : \"Risks playing Risk the Game\",\n" +
            "                     \"client_name\" : \"Nerds United\",\n" +
            "                     \"start_date\" : \"2016-01-04\",\n" +
            "                     \"start_yr\" : \"2016\",\n" +
            "                     \"end_date\" : \"2016-06-17\",\n" +
            "                     \"hours_pd\" : \"8.0\",\n" +
            "                     \"total_hours\" : \"960.0\",\n" +
            "                     \"task_days\" : \"120\",\n" +
            "                     \"task_cal_days\" : \"166\",\n" +
            "                     \"created_by\" : \"Admin Pearson\",\n" +
            "                     \"creator_id\" : \"40732\",\n" +
            "                     \"modified_by\" : \"Admin Pearson\",\n" +
            "                     \"priority\" : 0,\n" +
            "                     \"tentative\" : 0\n" +
            "                  }\n" +
            "               ]\n" +
            "         }\n" +
            "      ]\n" +
            "}";
}