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

public class CNActivity extends AppCompatActivity {


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
            setContentView(R.layout.activity_cnactivity);
            getSupportActionBar().setTitle("Computer Networks");
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
            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(CNActivity.this);
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
            quizModelArrayList.add(new QuizModel("The IETF standards documents are called ________","DFC", "RFC","RCF" ,"ID", "RFC"));
            quizModelArrayList.add(new QuizModel("The structure or format of data is called ___________","Syntax", "Semantics","Struct" ,"Formatting", "Semantics"));
            quizModelArrayList.add(new QuizModel("Communication between a computer and a keyboard involves ______________ transmission","Automatic", "Half-duplex","Full-duplex" ,"Simplex", "Simplex"));
            quizModelArrayList.add(new QuizModel("The first Network was called ________","CNNET", "NSFNET","ASAPNET","ARPANET","ARPANET"));
            quizModelArrayList.add(new QuizModel("A _______ is the physical path over which a message travels.", "Path","Medium","Protocol","Route","Medium"));
            quizModelArrayList.add(new QuizModel(" Which of this is not a network edge device?","PC", "Smartphones","Servers" ,"Switch", "Switch"));
            quizModelArrayList.add(new QuizModel(" A _________ set of rules that governs data communication.","Protocols", "Standard","RFCs" ,"Servers", "Protocols"));
            quizModelArrayList.add(new QuizModel("Three or more devices share a link in ________ connection.","Unipoint", "Multipoint","Point to point" ,"Simplex","Multipoint"));
            quizModelArrayList.add(new QuizModel("Which of the following terms is not associated with DSL?", "DSLAM","CO" ,"Splitters", "CMTS","CMTS"));
            quizModelArrayList.add(new QuizModel("HFC contains _______","Fibre cable", "Coaxial cable","A combination of Fibre cable and Coaxial cable","Twisted Pair Cable","A combination of Fibre cable and Coaxial cable"));
        }
    }