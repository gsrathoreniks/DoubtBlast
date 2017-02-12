package niks.doubtblast.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DSA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds);
    }

    public void onClickDSApract(View v){
        Intent intent = new Intent(this,dsa_pract.class);
        startActivity(intent);
    }
}
