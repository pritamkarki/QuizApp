package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    private Button submitButton;
    private int score;
    private RadioGroup numOneRadionGroup;
    private RadioGroup numTwoRadionGroup;
    private RadioGroup numFiveRadionGroup;

    private EditText editText;
    private CheckBox bootCheckbox;
    private CheckBox fileCheckbox;
    private CheckBox multiCheckbox;
    private CheckBox overwriteCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        bootCheckbox = findViewById(R.id.boot_checkbox);
        fileCheckbox = findViewById(R.id.file_checkbox);
        multiCheckbox = findViewById(R.id.multi_checkbox);
        overwriteCheckbox = findViewById(R.id.overwrite_checkbox);
        numOneRadionGroup = findViewById(R.id.num_one_radio_group);
        numTwoRadionGroup = findViewById(R.id.num_two_radio_group);
        numFiveRadionGroup = findViewById(R.id.num_five_radio_group);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = 0;

                if(numOneRadionGroup.getCheckedRadioButtonId() == R.id.above_radio){
                    score += 1;
                }

                if(numTwoRadionGroup.getCheckedRadioButtonId() == R.id.web_radio){
                    score += 1;
                }

                if(numFiveRadionGroup.getCheckedRadioButtonId() == R.id.gb_radio){
                    score += 1;
                }

                String userAnswer = editText.getText().toString();
                if(userAnswer.equalsIgnoreCase("ROM")){
                    score += 1;
                }

                if(bootCheckbox.isChecked() && fileCheckbox.isChecked() && multiCheckbox.isChecked()
                && overwriteCheckbox.isChecked()){
                    score += 2;
                }

            Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE", score+"/6");
            startActivity(intent);

            }
        });


    }
}




