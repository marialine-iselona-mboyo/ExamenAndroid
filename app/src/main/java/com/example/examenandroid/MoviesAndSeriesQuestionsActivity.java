package com.example.examenandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoviesAndSeriesQuestionsActivity extends AppCompatActivity implements View.OnClickListener{

    TextView allQuestions, question;
    Button opt1, opt2, opt3, btnNxtQ;

    int points = 0;
    int totalQuestions = MoviesAndSeriesQuestionAnswer.questionsMvl.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_and_series_questions);

        allQuestions = findViewById(R.id.tv_totalQuestionsMvl);
        question = findViewById(R.id.tv_questionAskedMvl);

        opt1 = findViewById(R.id.btnAnswerAMvl);
        opt1.setOnClickListener(this);
        opt2 = findViewById(R.id.btnAnswerBMvl);
        opt2.setOnClickListener(this);
        opt3 = findViewById(R.id.btnAnswerCMvl);
        opt3.setOnClickListener(this);

        btnNxtQ = findViewById(R.id.btn_nextQuestionMvl);
        btnNxtQ.setOnClickListener(this);


        allQuestions.setText("Total Questions: " + totalQuestions);


        loadOfQuestions();
    }


    @Override
    public void onClick(View v) {


        Button clickedBtn = (Button) v;
        if (clickedBtn.getId() == R.id.btn_nextQuestionMvl){
            if (selectedAnswer.equals(MoviesAndSeriesQuestionAnswer.answersMvl[currentQuestionIndex])){
                points++;
            }
            currentQuestionIndex++;
            loadOfQuestions();

        } else {
            selectedAnswer = clickedBtn.getText().toString();
        }
    }

    public void loadOfQuestions(){

        if (currentQuestionIndex == totalQuestions){
            endQuiz();
            return;
        }

        question.setText(MoviesAndSeriesQuestionAnswer.questionsMvl[currentQuestionIndex]);
        opt1.setText(MoviesAndSeriesQuestionAnswer.optionsMvl[currentQuestionIndex][0]);
        opt2.setText(MoviesAndSeriesQuestionAnswer.optionsMvl[currentQuestionIndex][1]);
        opt3.setText(MoviesAndSeriesQuestionAnswer.optionsMvl[currentQuestionIndex][2]);
    }

    private void endQuiz() {
        String passed = "";
        if (points > totalQuestions * 0.75){
            passed = "Passed";
        } else {
            passed = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passed)
                .setMessage("Score is " + points + " out of " + totalQuestions)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }

    public void restartQuiz(){
        points = 0;
        currentQuestionIndex =0;
        Intent intent=new Intent(getApplicationContext(),HomePageActivity.class);
        startActivity(intent);
    }
}