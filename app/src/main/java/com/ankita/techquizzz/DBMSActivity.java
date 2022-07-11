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

public class DBMSActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_dbmsactivity);
        getSupportActionBar().setTitle("DBMS");
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
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(DBMSActivity.this);
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
        quizModelArrayList.add(new QuizModel(" What is the full form of DBMS?","Data of Binary Management System", "Database Management System","Data Backup Management System" ,"Database Management Service", "Database Management System"));
        quizModelArrayList.add(new QuizModel("What is a database?","DBMS is a collection of queries", "DBMS is a high-level language","DBMS is a programming language" ,"DBMS stores, modifies and retrieves data", "DBMS stores, modifies and retrieves data"));
        quizModelArrayList.add(new QuizModel("Who created the first DBMS?","Edgar Frank Codd", "Charles Bachman","Charles Babbage" ,"Sharon B. Codd", "Charles Bachman"));
        quizModelArrayList.add(new QuizModel("Which type of data can be stored in the database?"," Image oriented data", "Text, files containing data","Data in the form of audio or video","All of the above","All of the above"));
        quizModelArrayList.add(new QuizModel("In which of the following formats data is stored in the database management system?", "Image","Text","Table","Graph","Table"));
        quizModelArrayList.add(new QuizModel(" Which of this is not a network edge device?","Hierarchical", "Network","Decentralized" ,"Distributed", "Decentralized"));
        quizModelArrayList.add(new QuizModel(" Which of the following is not an example of DBMS?","MySQL", "Microsoft Acess","IBM DB2" ,"Google", "Google"));
        quizModelArrayList.add(new QuizModel("Which of the following is a feature of DBMS?.","Minimum Duplication and Redundancy of Data", "High Level of Security" ,"Single-user Access only"," Support ACID Property","Single-user Access only"));
        quizModelArrayList.add(new QuizModel("Which of the following is a feature of the database?", "No-backup for the data stored","User interface provided" ,"Lack of Authentication", "Store data in multiple locations","User interface provided"));
        quizModelArrayList.add(new QuizModel(" Which of the following is not a function of the database?","Managing stored data", "Manipulating data","Security for stored data","Analysing code","Analysing code"));
    }
}
