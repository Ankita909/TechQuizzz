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

public class JavaActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_java);
        getSupportActionBar().setTitle("Java");
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
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(JavaActivity.this);
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
        quizModelArrayList.add(new QuizModel("Which of the following is true about Java?","It is a platform independent language", "It is Object Oriented Language","It is portable" ,"All of the above", "All of the above"));
        quizModelArrayList.add(new QuizModel("Which of the following is not an access modifier in Java?","Private", "Public","Protected" ,"Unprotected", "Unprotected"));
        quizModelArrayList.add(new QuizModel("Which component is used to compile, debug and execute the java programs?","JDK", "JRE","JIT" ,"JVM", "JDK"));
        quizModelArrayList.add(new QuizModel("What is the size of float and double in java?","64  and 32", "32 and 32","64 and 64","32 and 64","32 and 64"));
        quizModelArrayList.add(new QuizModel("Which of the following is a superclass of every class in Java?","ArrayList", "Abstract class","Object class","String","Object class"));
        quizModelArrayList.add(new QuizModel("In which of the following is toString() method defined?","java.lang.Object", "java.lang.util","String" ,"None", "java.lang.Object"));
        quizModelArrayList.add(new QuizModel("Total constructor string class have?","13", "14","15" ,"16", "13"));
        quizModelArrayList.add(new QuizModel("compareTo() returns","True", "False","none" ,"An integer value", "An integer value"));
        quizModelArrayList.add(new QuizModel("Where does the system stores parameters and local variables whenever a method is invoked?","Stack", "Heap","Tree" ,"Graph", "Stack"));
        quizModelArrayList.add(new QuizModel("Identify the corrected definition of a package.","A package is a collection of editing tools", "A package is a collection of classes","A package is a collection of classes and interfaces","A package is a collection of interfaces","A package is a collection of classes and interfaces"));
    }
}