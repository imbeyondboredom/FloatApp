package com.doesntexist.yourface.floatapi.models;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by charlie on 1/24/16.
 */
public class FloatPersonTest {

    private static final String PERSON_JSON = "{\n" +
            "\t\t\t\"people_id\": \"116707\",\n" +
            "\t\t\t\"name\": \"Some Person\",\n" +
            "\t\t\t\"job_title\": \"Software Engineer\",\n" +
            "\t\t\t\"avatar_file\": \"https://www.gravatar.com/avatar/c67049518043997fe9581d0df2422429?d=https%3A%2F%2F4f924a82f1b7a7989f8c-8c58e9ee3a00416a4085586f251e9af6.ssl.cf2.rackcdn.com%2Favatar-kale.png&s=40\",\n" +
            "\t\t\t\"department\": {\"name\":\"Android\",\"id\":\"23505\"},\n" +
            "\t\t\t\"skills\": [{\"name\": \"android\", \"level\": 3},{\"name\": \"charlottesville\", \"level\": 1}],\n" +
            "\t\t\t\"email\":  \"some.person@somewhere.com\",\n" +
            "\t\t\t\"description\":  \"\",\n" +
            "\t\t\t\"mobile\":  \"\",\n" +
            "\t\t\t\"telephone\":  \"\",\n" +
            "\t\t\t\"im\":  \"\",\n" +
            "\t\t\t\"wk_day_hrs\":  null,\n" +
            "\t\t\"non_wk_days\":  null,\n" +
            "\t\t\t\"employee_type\":  1,\n" +
            "\t\t\t\"contractor\":  0,\n" +
            "\t\t\t\"access_rights\": 0,\n" +
            "\t\t\t\"access_id\": 0,\n" +
            "\t\t\t\"department_filter_id\": null,\n" +
            "\t\t\t\"auto_email\": -1,\n" +
            "\t\t\t\"created\": \"2015-09-12\",\n" +
            "\t\t\t\"active\":  1\n" +
            "\t\t}";
    private Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
    }

    @Test
    public void testGsonParse() throws Exception {
        FloatPerson person = gson.fromJson(PERSON_JSON, FloatPerson.class);
        assertThat(person.id).isEqualTo(116707);
        assertThat(person.department.id).isEqualTo(23505);
        assertThat(person.department.name).isEqualTo("Android");
        assertThat(person.name).isEqualTo("Some Person");
        assertThat(person.tags.size()).isEqualTo(2);
        assertThat(person.tags.get(0).name).isEqualTo("android");
    }
}