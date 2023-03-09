package com.example.nyc_schools;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

//This could be better. To be honest was a little rusty with Java android
public class School implements Serializable {
    private String dbn;
    private String school_name;
    private String boro;
    private String overview_paragraph;
    private String school_10th_seats;
    private String academicopportunities1;
    private String academicopportunities2;
    private String ell_programs;
    private String neighorhood;
    private String building_code;
    private String location;
    private String phone_number;
    private String fax_number;
    private String school_email;
    private String website;
    private String subway;
    private String bus;
    private String grades2018;
    private String finalgrades;
    private String total_students;
    private String extracurricular_activities;
    private String school_sports;
    private String attendance_rate;
    private String pct_stu_enough_variety;
    private String pct_stu_safe;
    private String school_accessibility_description = null;
    private String directions1;
    private String requirement1_1;
    private String requirement2_1;
    private String requirement3_1;
    private String requirement4_1;
    private String requirement5_1;
    private String offer_rate1;
    private String program1;
    private String code1;
    private String interest1;
    private String method1;
    private String seates9ge1;
    private String grade9gefilledflag1;
    private String grade9geapplicants1;
    private String seats9swd1;
    private String grade9swdfilledflag1;
    private String grade9swdapplicants1;
    private String seats101;
    private String admissionspriority11;
    private String admissionspriority21;
    private String admissionspriority31;
    private String grade9geapplicantsperseat1;
    private String grade9swdapplicantsperseat1;
    private String primary_address_line_1;
    private String city;
    private String zip;
    private String state_code;
    private String latitude;
    private String longitude;
    private String community_board;
    private String council_district;
    private String census_tract;
    private String bin;
    private String bbl;
    private String nta;
    private String borough;

    public School() {

    }

    public String getName() {
        return this.school_name;
    }

    public School(
            String dbn,
            String school_name,
            String boro,
            String overview_paragraph,
            String school_10th_seats,
            String academicopportunities1,
            String academicopportunities2,
            String ell_programs,
            String neighorhood,
            String building_code,
            String location,
            String phone_number,
            String fax_number,
            String school_email,
            String website,
            String subway,
            String bus,
            String grades2018,
            String finalgrades,
            String total_students,
            String extracurricular_activities,
            String school_sports,
            String attendance_rate,
            String pct_stu_enough_variety,
            String pct_stu_safe,
            String school_accessibility_description,
            String directions1,
            String requirement1_1,
            String requirement2_1,
            String requirement3_1,
            String requirement4_1,
            String requirement5_1,
            String offer_rate1,
            String program1,
            String code1,
            String interest1,
            String method1,
            String seates9ge1,
            String grade9gefilledflag1,
            String grade9geapplicants1,
            String seats9swd1,
            String grade9swdfilledflag1,
            String grade9swdapplicants1,
            String seats101,
            String admissionspriority11,
            String admissionspriority21,
            String admissionspriority31,
            String grade9geapplicantsperseat1,
            String grade9swdapplicantsperseat1,
            String primary_address_line_1,
            String city,
            String zip,
            String state_code,
            String latitude,
            String longitude,
            String community_board,
            String council_district,
            String census_tract,
            String bin,
            String bbl,
            String nta,
            String borough

    ) {
        this.dbn = dbn;
        this.school_name = school_name;
        this.boro = boro;
        this.overview_paragraph = overview_paragraph;
        this.school_10th_seats = school_10th_seats;
        this.academicopportunities1 = academicopportunities1;
        this.academicopportunities2 = academicopportunities2;
        this.ell_programs = ell_programs;
        this.neighorhood = neighorhood;
        this.building_code = building_code;
        this.location = location;
        this.phone_number = phone_number;
        this.fax_number = fax_number;
        this.school_email = school_email;
        this.website = website;
        this.subway = subway;
        this.bus = bus;
        this.grades2018 = grades2018;
        this.finalgrades = finalgrades;
        this.total_students = total_students;
        this.extracurricular_activities = extracurricular_activities;
        this.school_sports = school_sports;
        this.attendance_rate = attendance_rate;
        this.pct_stu_enough_variety = pct_stu_enough_variety;
        this.pct_stu_safe = pct_stu_safe;
        this.school_accessibility_description = school_accessibility_description;
        this.directions1 = directions1;
        this.requirement1_1 = requirement1_1;
        this.requirement2_1 = requirement2_1;
        this.requirement3_1 = requirement3_1;
        this.requirement4_1 = requirement4_1;
        this.requirement5_1 = requirement5_1;
        this.offer_rate1 = offer_rate1;
        this.program1 = program1;
        this.code1 = code1;
        this.interest1 = interest1;
        this.method1 = method1;
        this.seates9ge1 = seates9ge1;
        this.grade9gefilledflag1 = grade9gefilledflag1;
        this.grade9geapplicants1 = grade9geapplicants1;
        this.seats9swd1 = seats9swd1;
        this.grade9swdfilledflag1 = grade9swdfilledflag1;
        this.grade9swdapplicants1 = grade9swdapplicants1;
        this.seats101 = seats101;
        this.admissionspriority11 = admissionspriority11;
        this.admissionspriority21 = admissionspriority21;
        this.admissionspriority31 = admissionspriority31;
        this.grade9geapplicantsperseat1 = grade9geapplicantsperseat1;
        this.grade9swdapplicantsperseat1 = grade9swdapplicantsperseat1;
        this.primary_address_line_1 = primary_address_line_1;
        this.city = city;
        this.zip = zip;
        this.state_code = state_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.community_board = community_board;
        this.council_district = council_district;
        this.census_tract = census_tract;
        this.bin = bin;
        this.bbl = bbl;
        this.nta = nta;
        this.borough = borough;
    }

    public static School fromJson(JSONObject obj) throws JSONException {
        return new School(
                obj.optString("dbn"),
                obj.optString("school_name"),
                obj.optString("boro"),
                obj.optString("overview_paragraph"),
                obj.optString("school_10th_seats"),
                obj.optString("academicopportunities1"),
                obj.optString("academicopportunities2"),
                obj.optString("ell_programs"),
                obj.optString("neighborhood"),
                obj.optString("building_code"),
                obj.optString("location"),
                obj.optString("phone_number"),
                obj.optString("fax_number"),
                obj.optString("school_email"),
                obj.optString("website"),
                obj.optString("subway"),
                obj.optString("bus"),
                obj.optString("grades2018"),
                obj.optString("finalgrades"),
                obj.optString("total_students"),
                obj.optString("extracurricular_activities"),
                obj.optString("school_sports"),
                obj.optString("attendance_rate"),
                obj.optString("pct_stu_enough_variety"),
                obj.optString("pct_stu_safe"),
                obj.optString("school_accessibility_description"),
                obj.optString("directions1"),
                obj.optString("requirement1_1"),
                obj.optString("requirement2_1"),
                obj.optString("requirement3_1"),
                obj.optString("requirement4_1"),
                obj.optString("requirement5_1"),
                obj.optString("offer_rate1"),
                obj.optString("program1"),
                obj.optString("code1"),
                obj.optString("interest1"),
                obj.optString("method1"),
                obj.optString("seats9ge1"),
                obj.optString("grade9gefilledflag1"),
                obj.optString("grade9geapplicants1"),
                obj.optString("seats9swd1"),
                obj.optString("grade9swdfilledflag1"),
                obj.optString("grade9swdapplicants1"),
                obj.optString("seats101"),
                obj.optString("admissionspriority11"),
                obj.optString("admissionspriority21"),
                obj.optString("admissionspriority31"),
                obj.optString("grade9geapplicantsperseat1"),
                obj.optString("grade9swdapplicantsperseat1"),
                obj.optString("primary_address_line_1"),
                obj.optString("city"),
                obj.optString("zip"),
                obj.optString("state_code"),
                obj.optString("latitude"),
                obj.optString("longitude"),
                obj.optString("community_board"),
                obj.optString("council_district"),
                obj.optString("census_tract"),
                obj.optString("bin"),
                obj.optString("bbl"),
                obj.optString("nta"),
                obj.optString("borough")
        );
    }

    public String getDbn() {
        return dbn;
    }

    public String getOverview_paragraph() {
        return overview_paragraph;
    }

    public String getBoro() {
        return boro;
    }

    public String getLocation() {
        return location;
    }
}
