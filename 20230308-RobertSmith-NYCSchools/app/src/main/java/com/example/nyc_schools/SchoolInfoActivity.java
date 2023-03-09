package com.example.nyc_schools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;
import com.example.nyc_schools.databinding.ActivitySchoolInfoBinding;


public class SchoolInfoActivity extends AppCompatActivity {

    private ActivitySchoolInfoBinding binding;

    private TextView numTestTakers;
    private TextView readingScore;
    private TextView mathScore;
    private TextView writingScore;
    private TextView addressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySchoolInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        numTestTakers = findViewById(R.id.numOfTesters);
        readingScore = findViewById(R.id.rightReadingTextView);
        mathScore = findViewById(R.id.rightMathTextView);
        writingScore = findViewById(R.id.rightWritingTextView);
        addressTextView = findViewById(R.id.addressTextView);

        SATModel model = (SATModel) getIntent().getSerializableExtra("SAT");
        School school = (School) getIntent().getSerializableExtra("SCHOOL");

        setTitle(model.school_name);

        if (model.num_of_sat_test_takers != null) {
            numTestTakers.setText(model.num_of_sat_test_takers + " test takers.");
        } else {
            numTestTakers.setText("NA test takers.");
        }
        readingScore.setText(model.sat_critical_reading_avg_score);
        mathScore.setText(model.sat_math_avg_score);
        writingScore.setText(model.sat_writing_avg_score);
        addressTextView.setText(school.getLocation()); //Would like to add linking to open maps.
        //Would also like to add contact info and style everything better.
    }
}