package niks.doubtblast.com;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static niks.doubtblast.com.R.styleable.AlertDialog;

/**
0 * Created by Niks on 09-09-2016.
 */
public class Chat_Room extends AppCompatActivity{

    Button btn_send_msg;
    EditText input_msg;
    TextView chat_conversation;
    String user_name,room_name;
    DatabaseReference root;
    private String temp_key;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room);

        btn_send_msg = (Button)findViewById(R.id.btn_send_c);
        input_msg =(EditText)findViewById(R.id.msg_input);
        chat_conversation =(TextView)findViewById(R.id.textView);

        room_name="a";
        setTitle("Introduction to C & C++");

        root = FirebaseDatabase.getInstance().getReference().child("a");
        request_user_name();
        btn_send_msg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Map<String,Object> map= new HashMap<>();
                temp_key = root.push().getKey();
                root.updateChildren(map);


                DatabaseReference message_root = root.child(temp_key);
                Map<String,Object> map2 = new HashMap<String, Object>();
                map2.put("name",user_name);
                map2.put("msg",input_msg.getText().toString());
                message_root.updateChildren(map2);
                input_msg.setText("");

            }
        });

        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                append_chat_conversation(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                append_chat_conversation(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    String chat_msg,chat_user_name;
    private void append_chat_conversation(DataSnapshot dataSnapshot) {
        Iterator i= dataSnapshot.getChildren().iterator();

        while(i.hasNext()){
            chat_msg= (String) ((DataSnapshot)i.next()).getValue();
            chat_user_name= (String) ((DataSnapshot)i.next()).getValue();
            chat_conversation.append(chat_user_name + ":\t" + chat_msg + "\n");

        }
    }

    private void request_user_name(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Name");

        final EditText input_field = new EditText(this);
        builder.setView(input_field);
        builder.setPositiveButton("ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                user_name = input_field.getText().toString();
                if(input_field.getText().toString().isEmpty())
                    request_user_name();
            }


        });
        builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                request_user_name();
            }
        });
        builder.show();
    }
}
