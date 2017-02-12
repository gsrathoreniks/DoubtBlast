package niks.doubtblast.com;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;

public class oop6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oop6);
        TextView txtFileName=(TextView)findViewById(R.id.tv2);


        AssetManager assetManager=getAssets();
        InputStream input;
        try {
            input=assetManager.open("oopPract6.txt");
            int size=input.available();
            byte[] buffer=new byte[size];
            input.read(buffer);
            input.close();

            String text=new String(buffer);
            txtFileName.setText(text);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
