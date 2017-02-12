package niks.doubtblast.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class oop_pract extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oop_pract);
    }
    public void onclick1(View v){
        Intent intent = new Intent(this,oop1.class);
        startActivity(intent);
    }public void onclick2(View v){
        Intent intent = new Intent(this,oop2.class);
        startActivity(intent);
    }public void onclick3(View v){
        Intent intent = new Intent(this,oop3.class);
        startActivity(intent);
    }public void onclick4(View v){
        Intent intent = new Intent(this,oop4.class);
        startActivity(intent);
    }public void onclick5(View v){
        Intent intent = new Intent(this,oop5.class);
        startActivity(intent);
    }public void onclick6(View v){
        Intent intent = new Intent(this,oop6.class);
        startActivity(intent);
    }
}
