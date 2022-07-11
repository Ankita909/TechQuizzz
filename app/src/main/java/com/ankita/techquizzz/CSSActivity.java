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

public class CSSActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_cssactivity);
        getSupportActionBar().setTitle("CSS");
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
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(CSSActivity.this);
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
        quizModelArrayList.add(new QuizModel("How can we change the background color of an element?","background-color", "color","both A and B" ,"None of the above", "background-color"));
        quizModelArrayList.add(new QuizModel("What type of CSS is generally recommended for designing large web pages?","Inline", "Internal","External" ,"None of the above", "External"));
        quizModelArrayList.add(new QuizModel("Which of the following CSS selectors are used to specify a group of elements?","tag", "id","class" ,"both class and tag", "class"));
        quizModelArrayList.add(new QuizModel("Which of the following CSS framework is used to create a responsive design?","django", "rails","larawell" ,"bootstrap", "bootstrap"));
        quizModelArrayList.add(new QuizModel("Which of the following CSS style property is used to specify an italic text?","style", "font","font-style" ,"@font-face", "font-style"));
        quizModelArrayList.add(new QuizModel("Which of the following are the CSS Extention Prefixes for Webkit?","-chrome", "-web","-o-" ,"-webkit", "-webkit"));
        quizModelArrayList.add(new QuizModel("Which of the following function defines a linear gradient as a CSS image?","gradient()", "linear-gradient()","grayscale()" ,"image()", "linear-gradient()"));
        quizModelArrayList.add(new QuizModel("The HTML attribute used to define the internal stylesheet is?","<style>", "style","<link>" ,"script", "<style>"));
        quizModelArrayList.add(new QuizModel("Are the negative values allowed in padding property?","Yes", "No","Can't say" ,"May be", "No"));
        quizModelArrayList.add(new QuizModel("Which of the following is not a type of combinator?",">", "~","+" ,"*", "*"));

    }
}