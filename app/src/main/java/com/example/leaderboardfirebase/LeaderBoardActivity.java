package com.example.leaderboardfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class LeaderBoardActivity extends AppCompatActivity {
   FirebaseDatabase database=FirebaseDatabase.getInstance();
   DatabaseReference myRef=database.getReference();
   LoginActivity activity=new LoginActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

   String Uid=     activity.user.Uid;
 DatabaseReference ref=  myRef.child(Uid).getRef();




    }
}
