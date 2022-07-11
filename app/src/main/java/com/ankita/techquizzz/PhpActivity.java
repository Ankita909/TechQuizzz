package com.ankita.techquizzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class PhpActivity extends AppCompatActivity {

    private TextView questionTv,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int current_score=0;
    int questions_attempted=1;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);
        getSupportActionBar().setTitle("PHP");
        questionTv=findViewById(R.id.TVQuestion);
        questionNumberTV=findViewById(R.id.TVQuestionAttempted);
        option1Btn=findViewById(R.id.BtnOption1);
        option2Btn=findViewById(R.id.BtnOption2);
        option3Btn=findViewById(R.id.BtnOption3);
        option4Btn=findViewById(R.id.BtnOption4);
        quizModelArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos=random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    current_score++;
                }
                questions_attempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    current_score++;
                }
                questions_attempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    current_score++;
                }
                questions_attempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    current_score++;
                }
                questions_attempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(PhpActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet,(LinearLayout)findViewById(R.id.LLScore));
        TextView scoreTV= bottomSheetView.findViewById(R.id.TVScore);
        Button restartQuizBtn=bottomSheetView.findViewById(R.id.btnRestart);
        scoreTV.setText("Your score is \n"+ current_score+ "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questions_attempted=1;
                current_score=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Number of Questions Attempted: " +questions_attempted+ "/10");
        if(questions_attempted==10){
            showBottomSheet();
        }else{
            questionTv.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText((quizModelArrayList.get(currentPos).getOption1()));
            option2Btn.setText((quizModelArrayList.get(currentPos).getOption2()));
            option3Btn.setText((quizModelArrayList.get(currentPos).getOption3()));
            option4Btn.setText((quizModelArrayList.get(currentPos).getOption4()));
        }
    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList){
        quizModelArrayList.add(new QuizModel("What is PHP?","It is a platform independent language", "PHP is used to develop dynamic and interactive websites"," PHP is a server-side scripting language" ,"All of the above", "All of the above"));
        quizModelArrayList.add(new QuizModel("Which of the following is the correct syntax to write a PHP code?","<?php ?>", "< php >","< ? php ?>" ,"<? ?>", "<? ?>"));
        quizModelArrayList.add(new QuizModel("Who is the father of PHP?","List Barely", "Drek Kolkevi","Willam Makepiece" ,"Rasmus Lerdorf", "Rasmus Lerdorf"));
        quizModelArrayList.add(new QuizModel("Which of the following is the default file extension of PHP files?",".php", ".ph",".html",".xml",".php"));
        quizModelArrayList.add(new QuizModel("How to define a function in PHP?","functionName(parameters) {function body}", " function {function body}","function functionName(parameters) {function body}","data type functionName(parameters) {function body}","function functionName(parameters) {function body}"));
        quizModelArrayList.add(new QuizModel("Which is the right way of declaring a variable in PHP?","$3hello", "$_hello","$this" ,"None", "$_hello"));
        quizModelArrayList.add(new QuizModel("Which of the following PHP functions can be used for generating unique ids?","md5()", "mdid()","uniqueid()" ,"id()", "uniqueid()"));
        quizModelArrayList.add(new QuizModel("Which of the following is the correct way to add a comment in PHP code?","#", "//","/**/" ,"All of the above", "All of the above"));
        quizModelArrayList.add(new QuizModel("What does PHP stand for?"," PHP stands for Preprocessor Home Page", " PHP stands for Pretext Hypertext Processor","PHP stands for Hypertext Preprocessor" ,"PHP stands for Personal Hyper Processo", "PHP stands for Hypertext Preprocessor"));
        quizModelArrayList.add(new QuizModel("Which of the following web servers are required to run the PHP script?","Apache and PHP", "IIS","XAMPP"," Any of the mentioned","IIS"));
    }
}
