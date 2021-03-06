package com.example.leaderboardfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
TextView name,email,password;
Button loginBtn;
FirebaseDatabase database= FirebaseDatabase.getInstance();
DatabaseReference myRef=database.getReference();
FirebaseAuth myAuth;
String uID;
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
                final String nameS,emailS,passS;
                nameS=name.getText().toString();
                emailS=email.getText().toString();
                passS=password.getText().toString();
                addUser();
                myAuth =FirebaseAuth.getInstance();
                myAuth.createUserWithEmailAndPassword(emailS,passS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this, "registerd", Toast.LENGTH_SHORT).show();
                            FirebaseUser firebaseUser;
                           firebaseUser= myAuth.getCurrentUser();
                            UserProfileChangeRequest request=new UserProfileChangeRequest.Builder().setDisplayName(nameS).
                                                                  build();
                          firebaseUser.updateProfile(request);

                        }
                    }
                });
            }

        });
    }
    public  void addUser()
    {    uID= myRef.push().getKey().toString();
        String nameS,emailS,passS;
        nameS=name.getText().toString();
        emailS=email.getText().toString();
        passS=password.getText().toString();
        User user=new User(nameS,emailS,passS,uID,0);
        myRef.child(uID).setValue(user);
    }
    public void test(View view)
    {
          startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }
}
