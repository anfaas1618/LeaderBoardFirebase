package com.example.leaderboardfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
TextView name,email,password;
Button loginBtn;
FirebaseDatabase database= FirebaseDatabase.getInstance();
DatabaseReference myRef=database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.txtName);
        email=findViewById(R.id.txtEmail);
        password=findViewById(R.id.txtPwd);
        loginBtn=findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addUser();
            }
        });
    }
    public  void addUser()
    {
        String nameS,emailS,passS;
        nameS=name.getText().toString();
        emailS=email.getText().toString();
        passS=password.getText().toString();
        User user=new User(nameS,emailS,passS);
        myRef.child(nameS).setValue(user);
    }
}
