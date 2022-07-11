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

public class PythonActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_python);
        getSupportActionBar().setTitle("Python");
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
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(PythonActivity.this);
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
        quizModelArrayList.add(new QuizModel("Which of the following modules need to be imported to handle date time computations in Python?","date","time","datetime","timedate", "datetime"));
        quizModelArrayList.add(new QuizModel("Which of the following is not a valid set operation in python?","Union", "Intersection","Difference" ,"None", "None"));
        quizModelArrayList.add(new QuizModel("What keyword is used in Python to raise exception","try", "goto","throw" ,"raise", "raise"));
        quizModelArrayList.add(new QuizModel("As what datatype are the *kwargs stored, when passed into a function?","List", "Tuple","Dictionary","All of the above","Dictionary"));
        quizModelArrayList.add(new QuizModel("Which of the following holds key:value pair?","Tuple", "Dictionary","List","none","Dictionary"));
        quizModelArrayList.add(new QuizModel("As what datatype are the *args stored, when passed into a function?","list", "tuple","dictionary" ,"None", "tuple"));
        quizModelArrayList.add(new QuizModel("Which of the following types of loops are not supported in Python?","for", "while","do while" ,"none", "do while"));
        quizModelArrayList.add(new QuizModel("Which of the following concepts is not a part of Python?","Dynamic typing", "Pointers","Curly Brackets" ,"Both 2 and 3", "Both 2 and 3"));
        quizModelArrayList.add(new QuizModel("How is a code block indicated in Python?","Indentation", "Brackets","Key","none","Indentation"));
        quizModelArrayList.add(new QuizModel("Which of the following are valid string manipulation functions in Python?","upper()", "count()","strip()","all of the above","Indentation"));
    }
}
