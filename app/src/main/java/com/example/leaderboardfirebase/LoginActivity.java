package com.example.leaderboardfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    TextView email,password;
    Button login;
    FirebaseAuth myAuth;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myREf=database.getReference();
     User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.btnLogin);
        email=findViewById(R.id.txtEmail);
        password=findViewById(R.id.txtPwd);
           myAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailS=email.getText().toString();
                final String passwordS=password.getText().toString();
              //  String emailS=email.getText().toString();
                myAuth.signInWithEmailAndPassword(emailS,passwordS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "login sucess", Toast.LENGTH_SHORT).show();
                            FirebaseUser firebaseUser=myAuth.getCurrentUser();
                            user=new User(firebaseUser.getDisplayName().toString(),
                                           firebaseUser.getEmail().toString(),
                                            passwordS,
                                             firebaseUser.getUid(),0);

                        }
                    }
                });
            }
        });
    }
}
