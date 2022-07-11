package com.ankita.techquizzz;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView java,cpp,python,sql,html5,js,php,css,cn,os,dbms,oops;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        java=(CardView) findViewById(R.id.cdjava);
        cpp=(CardView) findViewById(R.id.cdcpp);
        python=(CardView) findViewById(R.id.cdPython);
        sql=(CardView) findViewById(R.id.cdSql);
        html5=(CardView) findViewById(R.id.cdHtml5);
        js=(CardView) findViewById(R.id.cdJs);
        php=(CardView) findViewById(R.id.cdPhp);
        css=(CardView) findViewById(R.id.cdCss);
        cn=(CardView) findViewById(R.id.cdCn);
        os=(CardView) findViewById(R.id.cdOs);
        dbms=(CardView) findViewById(R.id.cdDbms);
        oops=(CardView) findViewById(R.id.cdOops);

        java.setOnClickListener(this);
        cpp.setOnClickListener(this);
        python.setOnClickListener(this);
        sql.setOnClickListener(this);
        html5.setOnClickListener(this);
        js.setOnClickListener(this);
        php.setOnClickListener(this);
        css.setOnClickListener(this);
        cn.setOnClickListener(this);
        os.setOnClickListener(this);
        dbms.setOnClickListener(this);
        oops.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case(R.id.cdjava):
                i=new Intent(this,JavaActivity.class);
                startActivity(i);
                break;

            case(R.id.cdcpp):
                i=new Intent(this,CppActivity.class);
                startActivity(i);
                break;

            case(R.id.cdPython):
                i=new Intent(this,PythonActivity.class);
                startActivity(i);
                break;

            case(R.id.cdSql):
                i=new Intent(this,SqlActivity.class);
                startActivity(i);
                break;

            case(R.id.cdHtml5):
                i=new Intent(this,HTML5Activity.class);
                startActivity(i);
                break;

            case(R.id.cdJs):
                i=new Intent(this,JSActivity.class);
                startActivity(i);
                break;

            case(R.id.cdCss):
                i=new Intent(this,CSSActivity.class);
                startActivity(i);
                break;

            case(R.id.cdCn):
                i=new Intent(this,CNActivity.class);
                startActivity(i);
                break;

            case(R.id.cdOs):
                i=new Intent(this,OSActivity.class);
                startActivity(i);
                break;

            case(R.id.cdDbms):
                i=new Intent(this,DBMSActivity.class);
                startActivity(i);
                break;

            case(R.id.cdOops):
                i=new Intent(this,OOPsActivity.class);
                startActivity(i);
                break;

            case(R.id.cdPhp):
                i=new Intent(this,PhpActivity.class);
                startActivity(i);
                break;

        }

    }
}