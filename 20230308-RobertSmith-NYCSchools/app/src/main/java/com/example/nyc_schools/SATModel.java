package com.example.nyc_schools;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class SATModel implements Serializable {
    public String dbn;
    public String school_name;
    public String num_of_sat_test_takers;
    public String sat_critical_reading_avg_score;
    public String sat_math_avg_score;
    public String sat_writing_avg_score;

    public SATModel() {}

    public SATModel(
            String dbn,
            String school_name,
            String num_of_sat_test_takers,
            String sat_critical_reading_avg_score,
            String sat_math_avg_score,
            String sat_writing_avg_score
    ) {
        this.dbn = dbn;
        this.school_name = school_name;
        this.num_of_sat_test_takers = num_of_sat_test_takers;
        this.sat_critical_reading_avg_score = sat_critical_reading_avg_score;
        this.sat_math_avg_score = sat_math_avg_score;
        this.sat_writing_avg_score = sat_writing_avg_score;
    }

    public static SATModel fromJson(JSONObject obj) throws JSONException {
        return new SATModel(
                obj.optString("dbn"),
                obj.optString("school_name"),
                obj.optString("num_of_sat_test_takers"),
                obj.optString("sat_critical_reading_avg_score"),
                obj.optString("sat_math_avg_score"),
                obj.optString("sat_writing_avg_score")
        );
    }
}
