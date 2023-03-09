package com.example.nyc_schools;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String url = "https://data.cityofnewyork.us/resource/s3k6-pzi2.json";
    private String satUrl = "https://data.cityofnewyork.us/resource/f9bf-2cp4.json";
    ProgressDialog dialog;


    ListView superListView;

    ArrayList<SATModel> satModels;
    ArrayList<School> schools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("List of Schools");

        superListView = findViewById(R.id.superListView);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        superListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SchoolInfoActivity.class);
                School school = schools.get(i);
                SATModel model = getModelForSchool(school.getDbn());
                if (model != null) {
                    intent.putExtra("SAT", model);
                    intent.putExtra("SCHOOL", school);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Data not found for school.", Toast.LENGTH_LONG).show();
                }
            }
        });

        StringRequest satRequest = new StringRequest(satUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseSATJsonData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Some error occurred!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Some error occurred!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);
        rQueue.add(satRequest);
    }

    //Loops through the SATModels to match with the school and sat DBN.
    SATModel getModelForSchool(String dbn) {
        for(int i = 0; i < satModels.size(); i++) {
            SATModel model = satModels.get(i);
            Log.w("ModelDBN", model.dbn);
            if (model.dbn.equals(dbn)) {
//            if (model.dbn == dbn) {
                return model;
            }
        }

        return null;
    }

    //Parses the JSON file for the SAT info
    void parseSATJsonData(String jsonString) {
        satModels = new ArrayList<SATModel>();
        try {
            JSONArray array = new JSONArray(jsonString);
            ArrayList<SATModel> sats = new ArrayList<>();
            ArrayList al = new ArrayList();

            for(int i = 0; i < array.length(); i++) {
                JSONObject obj = new JSONObject(array.getString(i));
                SATModel sat = jsonToSAT(obj);
                sats.add(sat);
                satModels.add(sat);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }

    //Parses the School data - This could be written to be more generic
    void parseJsonData(String jsonString) {
        try {
            JSONArray array = new JSONArray(jsonString);
            ArrayList<School> schools = new ArrayList<>();
            ArrayList al = new ArrayList();

            for(int i = 0; i < array.length(); i++) {
                JSONObject obj = new JSONObject(array.getString(i));
                School school = generateList(obj);
                schools.add(school);
                al.add(school.getName());
            }
            this.schools = schools;

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al) { //Had to override the getView to set the text to black. Wasn't working on phones with dark style set
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            };
            superListView.setAdapter(adapter);
        } catch(Exception e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }

    //Converts JSON string to object
    public SATModel jsonToSAT(JSONObject obj) {
        try {
            SATModel satModel = SATModel.fromJson(obj);
            return satModel;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Convert JSON string to object
    public School generateList(JSONObject school) {

        try {
            School s = School.fromJson(school);
            return s;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}